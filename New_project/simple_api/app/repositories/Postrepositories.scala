package repositories

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import play.modules.reactivemongo.ReactiveMongoApi
import play.api.libs.json._
import reactivemongo.play.json._
import reactivemongo.play.json.collection.JSONCollection
import reactivemongo.bson.{BSONDocument, BSONObjectID}
import reactivemongo.api.{Cursor, ReadPreference}
import models.details
import reactivemongo.api.commands.WriteResult

class Postrepositories @Inject()(
                                implicit ec: ExecutionContext,
                                reactiveMongoApi: ReactiveMongoApi
                                ) {
                                    private def collection: Future[JSONCollection] = reactiveMongoApi.database.map(_.collection("detail"))

                                    def list(limit:Int = 100): Future[Seq[details]] = collection.flatMap(_
                                      .find(BSONDocument())
                                        .cursor[details](ReadPreference.primary)
                                        .collect[Seq](limit,Cursor.FailOnError[Seq[details]]())
                                    )

                                    def create(post:details):Future[WriteResult] = collection.flatMap(_.insert(post))

                                    def read(id:BSONObjectID): Future[Option[details]] = collection.flatMap(_.find(BSONDocument("_id" -> id)).one[details])

                                    def update(id: BSONObjectID,post:details): Future[Option[details]] = collection.flatMap(_.findAndUpdate(
                                      BSONDocument("_id" -> id),
                                      BSONDocument(
                                        f"$$set" -> BSONDocument(
                                          "title" -> post.title,
                                          "description" -> post.description
                                        )
                                      ),
                                      true
                                    ).map(_.result[details]))

                                    def destroy(id: BSONObjectID): Future[Option[details]] = collection.flatMap(_.findAndRemove(BSONDocument("_id" -> id)).map(_.result[details]))
                                  }
