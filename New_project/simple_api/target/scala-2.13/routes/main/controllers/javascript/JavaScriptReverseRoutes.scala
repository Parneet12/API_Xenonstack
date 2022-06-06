// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:3
package controllers.javascript {

  // @LINE:3
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def ping: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.ping",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ping"})
        }
      """
    )
  
    // @LINE:6
    def getEmployeeDetailsByEmployeeId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getEmployeeDetailsByEmployeeId",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "employees/details/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:8
    def testmethod: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.testmethod",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "callme"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReversePostController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def listPosts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.listPosts",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "detail"})
        }
      """
    )
  
    // @LINE:18
    def deletePost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.deletePost",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "detail/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectId]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:16
    def updatePost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.updatePost",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "detail/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectId]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:14
    def readPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.readPost",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "detail/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectId]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:12
    def createPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.createPost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "detail"})
        }
      """
    )
  
  }


}
