// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:3
package controllers {

  // @LINE:3
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def ping: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ping")
    }
  
    // @LINE:6
    def getEmployeeDetailsByEmployeeId(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "employees/details/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:8
    def testmethod: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "callme")
    }
  
  }

  // @LINE:10
  class ReversePostController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def listPosts: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "detail")
    }
  
    // @LINE:18
    def deletePost(id:reactivemongo.bson.BSONObjectId): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "detail/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectId]].unbind("id", id)))
    }
  
    // @LINE:16
    def updatePost(id:reactivemongo.bson.BSONObjectId): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "detail/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectId]].unbind("id", id)))
    }
  
    // @LINE:14
    def readPost(id:reactivemongo.bson.BSONObjectId): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "detail/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectId]].unbind("id", id)))
    }
  
    // @LINE:12
    def createPost: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "detail")
    }
  
  }


}
