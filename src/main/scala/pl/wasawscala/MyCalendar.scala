package pl.warsawscala

import java.time.LocalDate

trait MyCalendar {
  def getEventsFor(from: LocalDate, to: LocalDate): Future[Seq[PlannedEvent]] // ???
}

object MyCalendar {
  //def apply(Code: String): MyCalendar = MyCalendarImp(Code)
  def apply(Code: String): MyCalendar = MyCalendarStub()
}

case class MyCalendarImp(Code: String) {
  def getEventsFor(from: LocalDate, to: LocalDate): Future[Seq[PlannedEvent]] {

  }
}

case class MyCalendarStub() {
  def getEventsFor(from: LocalDate, to: LocalDate): Future[Seq[PlannedEvent]] {
    Future {
    val myPlannedEvent: PlannedEvent = PlannedEvent (new LocalDate (2016, 3, 1), new LocalDate (2017, 3, 10), List ("holiday", "icecreamdays") )
    val myPlannedEvent2: PlannedEvent = PlannedEvent (new LocalDate (2016, 5, 5), new LocalDate (2016, 5, 10), List ("grilldays") )
    val myPlannedEvent3: PlannedEvent = PlannedEvent (new LocalDate (2016, 7, 1), new LocalDate (2016, 7, 5), List ("holiday") )
    val myFuture: Future[Seq[PlannedEvent]] = Future (List (myPlannedEvent, myPlannedEvent2, myPlannedEvent3) )
  }
  }
}

case class PlannedEvent(startDate: LocalDate, endDateExclusive: LocalDate, tags: Seq[String]) // ???

