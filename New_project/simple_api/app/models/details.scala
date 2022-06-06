package models

import play.api.libs.json.{Json,OFormat}
import reactivemongo.bson.BSONObjectID
import reactivemongo.play.json._

case class details(
                  _id: Option[BSONObjectID],
                  title: String,
                  description: String

                  )

object details {
  implicit val format: OFormat[details] = Json.format[details]
}
