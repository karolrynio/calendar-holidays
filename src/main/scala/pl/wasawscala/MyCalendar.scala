package pl.warsawscala

import java.time.LocalDate

trait MyCalendar {
  def getDaysFor(from: LocalDate, to: LocalDate): Seq[PlannedDay] // ???
}

case class PlannedDay(localDate: LocalDate, tags: Seq[String]) // ???