package types

import scala.scalajs.js.Date
import scala.scalajs.js.JSON
import scala.scalajs.js.Any

import utilities.JsonImplicits
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._

case class Week(
    weekNumber: String,
    days: List[Day]
) {
    def toJson(): String = {
        Printer.noSpaces
            .copy(dropNullValues = false)
            .print(
              Encoder[Week]
                  .apply(this)
            )
    }
    def getDayByNumber(number: String): Option[Day] = {
        days.filter(_.number == number).headOption
    }
}
