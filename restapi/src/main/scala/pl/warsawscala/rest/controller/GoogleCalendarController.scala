package pl.warsawscala.rest.controller

import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Singleton

import com.typesafe.scalalogging.StrictLogging
import org.joda.time.DateTime
import play.api.mvc.{Action, Controller, EssentialAction}

@Singleton
class GoogleCalendarController extends Controller with StrictLogging {

  val counter = new AtomicInteger()

  var map = Map[Int, (DateTime, DateTime)]()

  val START = "start"
  val END = "end"
  val CODE = "code"
  val STATE = "state"

  def holidays(): EssentialAction = Action {
    r =>
      val startTime = r.queryString.get(START).map(str => DateTime.parse(str.head)).getOrElse(DateTime.now().withMonthOfYear(1).withTimeAtStartOfDay().withDayOfMonth(1))
      val endTime = r.queryString.get(END).map(str => DateTime.parse(str.head)).getOrElse(DateTime.now().withMonthOfYear(12).withTimeAtStartOfDay().withDayOfMonth(31))
      logger.debug(s"$startTime $endTime")
      r.queryString.get(STATE) match {
        case Some(state) =>
          val id = state.head.toInt
          NotFound(s"$id")
        case None =>
          map = map + (counter.incrementAndGet() -> (startTime,endTime))
          Ok(s"$startTime $endTime")
          //Redirect(s"http://local/$startTime/$endTime")
      }


  }

}
