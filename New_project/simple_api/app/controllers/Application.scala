package controllers

import models.{EmployeeDetails, ErrorDetail}
import scala.concurrent.ExecutionContext
import javax.inject._
import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import play.twirl.api.HtmlFormat
import repositories.Postrepositories


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class Application @Inject()(implicit ec: ExecutionContext,cc: MessagesControllerComponents, postsRepo:Postrepositories) extends MessagesAbstractController(cc) with Logging {

  val employee = new EmployeeDetails

  def ping(): Action[AnyContent] = Action {
    implicit request: Request[AnyContent] => Ok("pong")
  }

  def getEmployeeDetailsByEmployeeId(id: Int): Action[AnyContent] = Action {
    implicit request: Request[AnyContent] =>
      employee.fetchEmployeeDetailsById(id) match {
        case details: HtmlFormat.Appendable => Ok(details)
        case errorCode: ErrorDetail if errorCode.statusCode == 400 => NotFound("No employee exist from this")
        case _ => InternalServerError("something went wrong")
      }
  }

  def testmethod = Action {
    implicit request => Ok("Method is here")
  }


    }

  }



}
