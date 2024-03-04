package configs

import types.TableConfig
import types.ColumnConfig
import types.{given}
import types.*
import client.AuroraClient

object CalenderConfig {
    val config = TableConfig[Week](
      new AuroraClient(),
      _.weekNumber,
      List(
        ColumnConfig[Week](
          CalenderDayDivType,
          "Sunday",
          "100px",
          _.days.filter(_.dayOfWeek == Sunday).head,
          "sunday"
        ),
        ColumnConfig[Week](
          CalenderDayDivType,
          "Monday",
          "100px",
          _.days.filter(_.dayOfWeek == Monday).head,
          "monday"
        ),
        ColumnConfig[Week](
          CalenderDayDivType,
          "Tuesday",
          "100px",
          _.days.filter(_.dayOfWeek == Tuesday).head,
          "tuesday"
        ),
        ColumnConfig[Week](
          CalenderDayDivType,
          "Wednesday",
          "100px",
          _.days.filter(_.dayOfWeek == Wednesday).head,
          "wednesday"
        ),
        ColumnConfig[Week](
          CalenderDayDivType,
          "Thursday",
          "100px",
          _.days.filter(_.dayOfWeek == Thursday).head,
          "thursday"
        ),
        ColumnConfig[Week](
          CalenderDayDivType,
          "Friday",
          "100px",
          _.days.filter(_.dayOfWeek == Friday).head,
          "friday"
        ),
        ColumnConfig[Week](
          CalenderDayDivType,
          "Saturday",
          "100px",
          _.days.filter(_.dayOfWeek == Saturday).head,
          "saturday"
        )
      )
    )
}
