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
  // @LINE:10
  PostController_1: controllers.PostController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:3
    Application_0: controllers.Application,
    // @LINE:10
    PostController_1: controllers.PostController
  ) = this(errorHandler, Application_0, PostController_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_0, PostController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ping""", """controllers.Application.ping"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """employees/details/""" + "$" + """id<[^/]+>""", """controllers.Application.getEmployeeDetailsByEmployeeId(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """callme""", """controllers.Application.testmethod"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """detail""", """controllers.PostController.listPosts"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """detail""", """controllers.PostController.createPost"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """detail/""" + "$" + """id<[^/]+>""", """controllers.PostController.readPost(id:reactivemongo.bson.BSONObjectId)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """detail/""" + "$" + """id<[^/]+>""", """controllers.PostController.updatePost(id:reactivemongo.bson.BSONObjectId)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """detail/""" + "$" + """id<[^/]+>""", """controllers.PostController.deletePost(id:reactivemongo.bson.BSONObjectId)"""),
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

  // @LINE:8
  private[this] lazy val controllers_Application_testmethod2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("callme")))
  )
  private[this] lazy val controllers_Application_testmethod2_invoker = createInvoker(
    Application_0.testmethod,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "testmethod",
      Nil,
      "GET",
      this.prefix + """callme""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_PostController_listPosts3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("detail")))
  )
  private[this] lazy val controllers_PostController_listPosts3_invoker = createInvoker(
    PostController_1.listPosts,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "listPosts",
      Nil,
      "GET",
      this.prefix + """detail""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_PostController_createPost4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("detail")))
  )
  private[this] lazy val controllers_PostController_createPost4_invoker = createInvoker(
    PostController_1.createPost,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "createPost",
      Nil,
      "POST",
      this.prefix + """detail""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_PostController_readPost5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("detail/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_readPost5_invoker = createInvoker(
    PostController_1.readPost(fakeValue[reactivemongo.bson.BSONObjectId]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "readPost",
      Seq(classOf[reactivemongo.bson.BSONObjectId]),
      "GET",
      this.prefix + """detail/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_PostController_updatePost6_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("detail/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_updatePost6_invoker = createInvoker(
    PostController_1.updatePost(fakeValue[reactivemongo.bson.BSONObjectId]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "updatePost",
      Seq(classOf[reactivemongo.bson.BSONObjectId]),
      "PUT",
      this.prefix + """detail/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_PostController_deletePost7_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("detail/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_deletePost7_invoker = createInvoker(
    PostController_1.deletePost(fakeValue[reactivemongo.bson.BSONObjectId]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "deletePost",
      Seq(classOf[reactivemongo.bson.BSONObjectId]),
      "DELETE",
      this.prefix + """detail/""" + "$" + """id<[^/]+>""",
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
  
    // @LINE:8
    case controllers_Application_testmethod2_route(params@_) =>
      call { 
        controllers_Application_testmethod2_invoker.call(Application_0.testmethod)
      }
  
    // @LINE:10
    case controllers_PostController_listPosts3_route(params@_) =>
      call { 
        controllers_PostController_listPosts3_invoker.call(PostController_1.listPosts)
      }
  
    // @LINE:12
    case controllers_PostController_createPost4_route(params@_) =>
      call { 
        controllers_PostController_createPost4_invoker.call(PostController_1.createPost)
      }
  
    // @LINE:14
    case controllers_PostController_readPost5_route(params@_) =>
      call(params.fromPath[reactivemongo.bson.BSONObjectId]("id", None)) { (id) =>
        controllers_PostController_readPost5_invoker.call(PostController_1.readPost(id))
      }
  
    // @LINE:16
    case controllers_PostController_updatePost6_route(params@_) =>
      call(params.fromPath[reactivemongo.bson.BSONObjectId]("id", None)) { (id) =>
        controllers_PostController_updatePost6_invoker.call(PostController_1.updatePost(id))
      }
  
    // @LINE:18
    case controllers_PostController_deletePost7_route(params@_) =>
      call(params.fromPath[reactivemongo.bson.BSONObjectId]("id", None)) { (id) =>
        controllers_PostController_deletePost7_invoker.call(PostController_1.deletePost(id))
      }
  }
}
