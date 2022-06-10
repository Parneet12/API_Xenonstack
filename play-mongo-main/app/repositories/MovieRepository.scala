package repositories

import models.Movie
import javax.inject._
import reactivemongo.api.bson.collection.BSONCollection
import play.modules.reactivemongo.ReactiveMongoApi
import scala.concurrent.{ExecutionContext, Future}
import reactivemongo.api.{Cursor, ReadPreference}
import reactivemongo.bson.{BSONDocument, BSONObjectID}
import org.joda.time.DateTime
import reactivemongo.api.commands.WriteResult


@Singleton
class MovieRepository @Inject()(     //@inject is used when we require other component as dependencies
                                 implicit executionContext: ExecutionContext,
                                 reactiveMongoApi: ReactiveMongoApi
                               ) {
  def collection: Future[BSONCollection] = reactiveMongoApi.database.map(db => db.collection("movies"))

  def findAll(limit: Int = 100): Future[Seq[Movie]] = {       /*Future: Future provides a way to perform many operation
                                                                        in parallel in an efficient and
                                                                        non blocking way.*/

    collection.flatMap(                     //in flatmap inner grouping of item is removed and sequence is generated
      _.find(BSONDocument(), Option.empty[Movie])       //Option.empty signify that it is none but could become something in future using (Some)
        .cursor[Movie](ReadPreference.Primary)
        .collect[Seq](limit, Cursor.FailOnError[Seq[Movie]]())
    )
  }

  def findOne(id: BSONObjectID): Future[Option[Movie]] = {
    collection.flatMap(_.find(BSONDocument("_id" -> id), Option.empty[Movie]).one[Movie])  // find syntax: find(Selector,projection)
  }

  def create(movie: Movie): Future[WriteResult] = {
    collection.flatMap(_.insert(ordered = false)
      .one(movie.copy(_creationDate = Some(new DateTime()), _updateDate = Some(new DateTime()))))
  }

  def update(id: BSONObjectID, movie: Movie):Future[WriteResult] = {

    collection.flatMap(
      _.update(ordered = false).one(BSONDocument("_id" -> id),
        movie.copy(
          _updateDate = Some(new DateTime())))
    )
  }

  def delete(id: BSONObjectID):Future[WriteResult] = {
    collection.flatMap(
      _.delete().one(BSONDocument("_id" -> id), Some(1))
    )
  }


}