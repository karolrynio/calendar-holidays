package pl.warsawscala.rest.controller

import javax.inject.Singleton

import pl.warsawscala.rest.model.Login
import play.api.libs.json.{JsError, JsSuccess}
import play.api.mvc.{Action, BodyParsers, Controller, EssentialAction}

@Singleton
class GoogleCalendarController extends Controller {

  def login(): EssentialAction = Action(BodyParsers.parse.json) {
    r =>
      r.body.validate[Login] match {
        case JsSuccess(login, _) =>
          Ok("")
        case JsError(errors) =>
          BadRequest(s"$errors")
      }
  }

}
