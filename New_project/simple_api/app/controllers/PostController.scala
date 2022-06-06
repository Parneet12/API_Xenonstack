package controllers

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}
import play.api._
import play.api.mvc._
import play.api.libs.json._
import reactivemongo.bson.BSONObjectID
import models.details
import repositories.Postrepositories

class PostController @Inject()(

                                implicit ec: ExecutionContext,
                              components: ControllerComponents,
                              postsRepo: Postrepositories
                              ) extends AbstractController(components) {
  def listPosts = Action.async {
    postsRepo.list().map {
      detail => Ok(Json.toJson(detail))

    }
  }

  def createPost = Action.async(parse.json) {
    _.body
      .validate[details]
      .map { post => postsRepo.create(post).map {_ => Created}}
      .getOrElse(Future.successful(BadRequest("Invalid Format")))
  }

  def readPost(id: BSONObjectID) = Action.async
  {
      postsRepo.read(id).map {maybePost => maybePost.map { post => Ok(Json.toJson(post))}.getOrElse(NotFound)}
  }

  def updatePost(id: BSONObjectID) = Action.async(parse.json)
  {
    _.body
      .validate[details]
      .map {post => postsRepo.update(id, post).map {
        case Some(post) => Ok(Json.toJson(post))
        case _          => NotFound
      }}
      .getOrElse(Future.successful(BadRequest("Invalid Format")))
  }

  def deletePost(id:BSONObjectID) = Action.async {
    postsRepo.destroy(id).map {
      case Some(post) => Ok(Json.toJson(post))
      case _          => NotFound
    }
  }



}
