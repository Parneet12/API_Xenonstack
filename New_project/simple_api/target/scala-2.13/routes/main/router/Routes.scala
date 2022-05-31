// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:3
  Application_0: controllers.Application,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:3
    Application_0: controllers.Application
  ) = this(errorHandler, Application_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ping""", """controllers.Application.ping"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """employees/details/""" + "$" + """id<[^/]+>""", """controllers.Application.getEmployeeDetailsByEmployeeId(id:Int)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:3
  private[this] lazy val controllers_Application_ping0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ping")))
  )
  private[this] lazy val controllers_Application_ping0_invoker = createInvoker(
    Application_0.ping,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "ping",
      Nil,
      "GET",
      this.prefix + """ping""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_Application_getEmployeeDetailsByEmployeeId1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("employees/details/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getEmployeeDetailsByEmployeeId1_invoker = createInvoker(
    Application_0.getEmployeeDetailsByEmployeeId(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getEmployeeDetailsByEmployeeId",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """employees/details/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:3
    case controllers_Application_ping0_route(params@_) =>
      call { 
        controllers_Application_ping0_invoker.call(Application_0.ping)
      }
  
    // @LINE:6
    case controllers_Application_getEmployeeDetailsByEmployeeId1_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_Application_getEmployeeDetailsByEmployeeId1_invoker.call(Application_0.getEmployeeDetailsByEmployeeId(id))
      }
  }
}
