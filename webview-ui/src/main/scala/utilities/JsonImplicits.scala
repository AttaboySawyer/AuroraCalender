package utilities

import io.circe.Decoder
import io.circe.generic.semiauto._
import io.circe.DecodingFailure
import io.circe.Encoder
import io.circe.Json
import types.Day
import types.Message
import types.BasicMessage
import types.Shift

object JsonImplicits {

    implicit val dayDecoder: Decoder[Day] = deriveDecoder[Day]
    implicit val dayEncoder: Encoder[Day] = deriveEncoder[Day]

    implicit val shiftDecoder: Decoder[Shift] = deriveDecoder[Shift]
    implicit val shiftEncoder: Encoder[Shift] = deriveEncoder[Shift]

    implicit val messageDecoder: Decoder[BasicMessage] =
        deriveDecoder[BasicMessage]
    implicit val messageEncoder: Encoder[BasicMessage] =
        deriveEncoder[BasicMessage]

}
