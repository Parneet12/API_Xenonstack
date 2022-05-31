
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object EmployeeDetails extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(name: String, address: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.33*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sample</title>
</head>
<body>
<P><b> Name:-</b> """),_display_(/*10.20*/name),format.raw/*10.24*/("""</P>
<P><b> Address:-</b> """),_display_(/*11.23*/address),format.raw/*11.30*/("""</P>
</body>
</html>"""))
      }
    }
  }

  def render(name:String,address:String): play.twirl.api.HtmlFormat.Appendable = apply(name,address)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (name,address) => apply(name,address)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/EmployeeDetails.scala.html
                  HASH: 85ca552cbc5ba1a508410e1a31e5bf1afa276517
                  MATRIX: 746->1|872->32|902->36|1063->170|1088->174|1143->202|1171->209
                  LINES: 21->1|26->1|28->3|35->10|35->10|36->11|36->11
                  -- GENERATED --
              */
          