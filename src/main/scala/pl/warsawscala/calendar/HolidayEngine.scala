package pl.warsawscala.calendar

import java.time.LocalDate
import java.time.temporal.{ChronoUnit, TemporalAdjusters}

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

trait HolidayEngine {
  /**
    *
    * @param from opcjonalna data od (jeżeli brak liczymy od początku bieżącego roku)
    * @param to   opcjonalna data do (jęzeli brak liczymy do końca bieżącego roku)
    * @return liczbę zaplanowanych dni urlopowych
    */
  def countHolidays(from: Option[LocalDate] = None, to: Option[LocalDate] = None): Future[Int]

  /**
    *
    * @param year rok dla którego liczymy pozostałe dni wolne (jeżeli brak liczymy dla bieżącego roku)
    * @return liczba pozostałych dni urlopowych
    */
  def countHolidaysLeftInYear(year: Option[Int] = None): Future[Int]
}

class HolidayEngineImpl(myCalendar: MyCalendar) extends HolidayEngine {
  override def countHolidays(from: Option[LocalDate] = None, to: Option[LocalDate] = None): Future[Int] = {
    val year: Int = LocalDate.now().getYear
    val dateFrom: LocalDate = from.getOrElse(LocalDate.now().`with`(TemporalAdjusters.firstDayOfYear()))
    val dateTo: LocalDate = from.getOrElse(LocalDate.now().`with`(TemporalAdjusters.lastDayOfYear()))
    myCalendar.getEventsFor(dateFrom, dateTo).map(events => {
      events.filter(_.tags.contains("holiday"))
        .map(event => ChronoUnit.DAYS.between(event.startDate, event.endDateExclusive))
        .sum.toInt
    })
  }

  override def countHolidaysLeftInYear(year: Option[Int] = None): Future[Int] = ???
}
