package pl.warsawscala.calendar

import java.time.LocalDate

import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.mockito.Mockito._
import org.mockito.Matchers._
import scala.concurrent.ExecutionContext.Implicits.global

class HolidayEngineSpec extends Specification with Mockito {
  "Holiday engine" should {
    "return 0 if no holidays have been used" in {
      val mockCalendar = mock[MyCalendar]
      val holidayEngine = new HolidayEngineImpl(mockCalendar)
      mockCalendar.getEventsFor(any[LocalDate], any[LocalDate]) returns (Future { Seq.empty })
      Await.result(holidayEngine.countHolidays(), Duration.Inf) === 0
    }
    "return number of holidays between dates" in {
      val mockCalendar = MyCalendarStub()
      val holidayEngine = new HolidayEngineImpl(mockCalendar)
      Await.result(holidayEngine.countHolidays(), Duration.Inf) === 378
    }
  }
}
