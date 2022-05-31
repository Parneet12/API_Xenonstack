package controllers

import javax.inject._
import models.User
import play.api._
import play.api.mvc._
import play.api.libs.json._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {


  def users() = Action { implicit request: Request[AnyContent] =>
    val users = List(User())
    Ok(Json.toJson(users)).as("application/json ")
  }

  def user(userId:String) = Action { implicit request: Request[AnyContent] =>
    val user = User(id = userId)
    Ok(Json.toJson(user)).as("application/json ")
}

  def add() = Action(parse.json) {implicit request: Request[JsValue] =>
    val userResult = request.body.validate[User]
    userResult.fold (
      errors => {
        BadRequest(Json.obj("status" -> "error", "message" -> JsError.toJson(errors)))
      },
      user => {
        Ok(Json.toJson(user)).as("application/json")
      }
    )
  }
  }
