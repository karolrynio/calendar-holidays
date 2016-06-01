package pl.warsawscala.calendar

import java.time.LocalDate

import scala.concurrent.{ExecutionContext, Future}

trait MyCalendar {
  def getEventsFor(from: LocalDate, to: LocalDate)(implicit ec: ExecutionContext): Future[Seq[PlannedEvent]] // ???
}

object MyCalendar {
  //def apply(Code: String): MyCalendar = MyCalendarImp(Code)
  def apply(Code: String): MyCalendar = MyCalendarStub()
}
/*
case class MyCalendarImp(Code: String) extends MyCalendar {
  def getEventsFor(from: LocalDate, to: LocalDate): Future[Seq[PlannedEvent]] = {
  }
}
*/

case class MyCalendarStub() extends MyCalendar {
  def getEventsFor(from: LocalDate, to: LocalDate)(implicit ec: ExecutionContext): Future[Seq[PlannedEvent]] = {
    Future {
      val myPlannedEvent: PlannedEvent = PlannedEvent(LocalDate.of(2016, 3, 1), LocalDate.of(2017, 3, 10), List("holiday", "icecreamdays"))
      val myPlannedEvent2: PlannedEvent = PlannedEvent(LocalDate.of(2016, 5, 5), LocalDate.of(2016, 5, 10), List("grilldays"))
      val myPlannedEvent3: PlannedEvent = PlannedEvent(LocalDate.of(2016, 7, 1), LocalDate.of(2016, 7, 5), List("holiday"))
      List(myPlannedEvent, myPlannedEvent2, myPlannedEvent3)
    }
  }
}

case class PlannedEvent(startDate: LocalDate, endDateExclusive: LocalDate, tags: Seq[String]) // ???

