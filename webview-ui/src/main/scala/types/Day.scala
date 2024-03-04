package types

import scala.scalajs.js.Date
import scala.scalajs.js.JSON
import scala.scalajs.js.Any

import utilities.JsonImplicits
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._

sealed trait DayOfWeek
case object Sunday extends DayOfWeek
case object Monday extends DayOfWeek
case object Tuesday extends DayOfWeek
case object Wednesday extends DayOfWeek
case object Thursday extends DayOfWeek
case object Friday extends DayOfWeek
case object Saturday extends DayOfWeek

case class Day(
    dayOfWeek: DayOfWeek,
    number: String,
    month: String,
    years: String,
    shifts: List[Shift]
) {
    def toJson(): String = {
        Printer.noSpaces
            .copy(dropNullValues = false)
            .print(
              Encoder[Day]
                  .apply(this)
            )
    }
}
