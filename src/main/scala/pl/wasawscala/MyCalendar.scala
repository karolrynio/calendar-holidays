package pl.wasawscala

import java.time.LocalDate

trait MyCalendar {
  def getDaysFor(from: LocalDate, to: LocalDate): Seq[PlanedDay] // ???
}

case class PlanedDay(localDate: LocalDate, tags: Seq[String]) // ???