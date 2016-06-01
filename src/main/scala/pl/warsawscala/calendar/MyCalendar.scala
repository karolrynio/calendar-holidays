package pl.warsawscala.calendar

import java.time.LocalDate

import scala.concurrent.Future

trait MyCalendar {
  def getEventsFor(from: LocalDate, to: LocalDate): Future[Seq[PlannedEvent]] // ???
}

case class PlannedEvent(startDate: LocalDate, endDateExclusive: LocalDate, tags: Seq[String]) // ???