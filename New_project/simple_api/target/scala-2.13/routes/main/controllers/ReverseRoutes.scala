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
  
  }


}
