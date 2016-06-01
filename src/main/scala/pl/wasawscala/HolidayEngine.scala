package pl.warsawscala.calendar

import java.time.LocalDate

trait HolidayEngine {
  def countHolidaysFor(from: LocalDate, to: LocalDate): Int
  def countInCurrentYear(): Int
}
