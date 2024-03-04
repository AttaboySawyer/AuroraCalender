package types

import scala.scalajs.js.Date
import scala.scalajs.js.JSON
import scala.scalajs.js.Any

import utilities.JsonImplicits
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._

case class Shift(
    worker: String
    // designation: String
    // statTime: String,
    // endTime: String
) {
    def toJson(): String = {
        Printer.noSpaces
            .copy(dropNullValues = false)
            .print(
              Encoder[Shift]
                  .apply(this)
            )
    }
}
