package controllers   // Job of controller is that they repond to an action and process them and may also invoke changes in the model

import javax.inject._
import play.api.mvc._
import repositories.MovieRepository
import reactivemongo.bson.BSONObjectID
import play.api.libs.json.{Json, __}
import scala.util.{Failure, Success}
import scala.concurrent.{ExecutionContext, Future}

import models.Movie
import play.api.libs.json.JsValue

@Singleton            // Used to create single instance of component.
class MovieController @Inject()(        //@inject is used when we require other component as dependencies
                                 implicit executionContext: ExecutionContext,
                                 val movieRepository: MovieRepository,
                                 val controllerComponents: ControllerComponents)
  extends BaseController {
  def findAll():Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>    //This end point will return the movie list
    movieRepository.findAll().map {
      movies => Ok(Json.toJson(movies))                                   //Json.toJson is used to convert scala to JSvalue
    }
  }

  def findOne(id:String):Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>  /*This end point will parse
                                                                                          the given id and return associate movie if its found.*/
    val objectIdTryResult = BSONObjectID.parse(id)
    objectIdTryResult match {
      case Success(objectId) => movieRepository.findOne(objectId).map {
        movie => Ok(Json.toJson(movie))
      }
      case Failure(_) => Future.successful(BadRequest("Cannot parse the movie id"))
    }
  }

  def create():Action[JsValue] = Action.async(controllerComponents.parsers.json) { implicit request => {   /*implicit request is used here which
                                                                                                              means value is taken from
                                                                                                              context in which they are called*/


    request.body.validate[Movie].fold(                //.validate is used to check if the json is valid or not.
      _ => Future.successful(BadRequest("Cannot parse request body")),
      movie =>
        movieRepository.create(movie).map {
          _ => Created(Json.toJson(movie))
        }
    )
  }}

  def update(id: String):Action[JsValue]  = Action.async(controllerComponents.parsers.json) { implicit request => {
    request.body.validate[Movie].fold(                  //Action.async is used to send asynchronous result
      _ => Future.successful(BadRequest("Cannot parse request body")),
      movie =>{
        val objectIdTryResult = BSONObjectID.parse(id)
        objectIdTryResult match {
          case Success(objectId) => movieRepository.update(objectId, movie).map {
            result => Ok(Json.toJson(result.ok))
          }
          case Failure(_) => Future.successful(BadRequest("Cannot parse the movie id"))
        }
      }
    )
  }}

  def delete(id: String):Action[AnyContent]  = Action.async { implicit request => {
    val objectIdTryResult = BSONObjectID.parse(id)
    objectIdTryResult match {
      case Success(objectId) => movieRepository.delete(objectId).map {
        _ => NoContent
      }
      case Failure(_) => Future.successful(BadRequest("Cannot parse the movie id"))
    }
  }}
}