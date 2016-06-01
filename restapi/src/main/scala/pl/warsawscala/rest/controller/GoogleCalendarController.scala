package pl.warsawscala.rest.controller

import javax.inject.Singleton

import com.typesafe.scalalogging.StrictLogging
import org.joda.time.DateTime
import play.api.mvc.{Action, Controller, EssentialAction}

@Singleton
class GoogleCalendarController extends Controller with StrictLogging{

  var map = Map[String, (DateTime,DateTime)]()


  def holidays(startTime: DateTime, endTime: DateTime): EssentialAction = Action {
    r =>
      logger.debug(s"$startTime $endTime")
      Redirect(s"http://www.google.pl/$startTime/$endTime")
  }

}
