package models
import play.api.libs.json.Json

case class User(
               id:String   =   "A-001",
               name:String =   "Parneet",
               age : Int     =    22
               )

object User {
  implicit val userImplicitReads = Json.reads[User]
  implicit val userImplicitWrites = Json.writes[User]
}