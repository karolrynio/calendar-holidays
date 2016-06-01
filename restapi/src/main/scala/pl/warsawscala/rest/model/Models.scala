package pl.warsawscala.rest.model

import play.api.libs.json.Json

object Login {
  val empty = Login("", "")

  implicit val format = Json.format[Login]
}

case class Login(username: String, password: String)
