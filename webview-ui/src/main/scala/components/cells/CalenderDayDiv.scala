package components.cells

import components.AuroraElement
import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.HTMLTableCellElement
import org.scalajs.dom
import org.scalajs.dom.KeyboardEvent
import org.scalajs.dom.FocusEvent
import components.utils.DomUtils.removeClassnameFromAll
import components.utils.DomUtils.addClassnameToElement

import org.scalajs.dom.Element
import org.scalajs.dom.HTMLElement
import com.raquo.laminar.nodes.ReactiveHtmlElement
import cats.instances.boolean
import client.AuroraClient
import types.Shift
import types.Day

case class CalenderDayDiv(
    day: Day,
    client: AuroraClient,
    fieldName: String,
    rowId: String
) extends AuroraElement {

    val showAddButton = Var(false)

    def renderAddButton(show: Signal[Boolean]): Signal[HtmlElement] = {
        show.map {
            case true =>
                div(
                  className := "addShiftButton",
                  "➕",
                  onClick --> (e => {
                      println(fieldName)
                  })
                )
            case false => div()
        }
    }
    def renderShifts(day: Day) = {
        day.shifts.map(shift => {
            td(
              shift.worker,
              draggable := true,
              onMouseDown --> { (e) =>
                  {
                      e.ctrlKey match {
                          case true => {
                              dom.document
                                  .getElementsByTagName("td")
                                  .toList
                                  .map(_.classList.remove("copied-cell"))
                              e.target
                                  .asInstanceOf[HTMLTableCellElement]
                                  .classList
                                  .add("copied-cell")
                              client.copiedContent.update(content =>
                                  Some(
                                    Shift(
                                      e.target
                                          .asInstanceOf[HTMLTableCellElement]
                                          .innerText
                                    )
                                  )
                              )
                              println(
                                "copying " + e.target
                                    .asInstanceOf[HTMLTableCellElement]
                                    .innerText + " from day " + day.number
                              )
                              // println(client.copiedContent.now())
                          }
                          case false =>
                              e.altKey match {
                                  case true =>
                                      dom.document
                                          .getElementsByTagName("td")
                                          .toList
                                          .map(
                                            _.classList.remove("copied-cell")
                                          )
                                      e.target
                                          .asInstanceOf[HTMLTableCellElement]
                                          .classList
                                          .add("copied-cell")
                                      client.copiedContent.update(content =>
                                          Some(
                                            Shift(
                                              e.target
                                                  .asInstanceOf[
                                                    HTMLTableCellElement
                                                  ]
                                                  .innerText
                                            )
                                          )
                                      )
                                      println(
                                        "continuous copying " + e.target
                                            .asInstanceOf[HTMLTableCellElement]
                                            .innerText + " from day " + day.number
                                      )
                                  case false =>
                              }
                      }

                  }
              },
              onMouseUp --> { (e) =>
                  {
                      println(
                        "pasting " + e.target
                            .asInstanceOf[HTMLTableCellElement]
                            .innerText + " to day " + day.number
                      )
                  }
              }
            )
        })
    }

    def render() = {
        td(
          verticalAlign := "top",
          onMouseDown --> { (e) => e.preventDefault() },
          div(
            display := "flex",
            flexDirection := "column",
            minHeight := "150px",
            tabIndex := 0,
            onClick --> (e => e.target.asInstanceOf[HTMLElement].focus()),
            onDblClick --> (e => println("Cannot edit this field.")),
            onMouseEnter --> (e => showAddButton.update(bool => true)),
            onMouseLeave --> (e => showAddButton.update(bool => false)),
            onMouseEnter --> { (e) =>
                {
                    e.altKey match {
                        case true => {
                            client.copiedContent.signal
                                .now() match {
                                case Some(value) => {
                                    println(
                                      "pasting " + value + " to day " + day.number
                                    )

                                    client.dataModelVar.update(weeks => {
                                        weeks
                                            .map(week =>
                                                week.copy(
                                                  days =
                                                      week.days.map(weekday => {
                                                          if (
                                                            weekday.number == day.number
                                                          ) {
                                                              val updatedShifts = if (
                                                                !weekday.shifts
                                                                    .contains(
                                                                      value
                                                                    )
                                                              ) {
                                                                  value :: weekday.shifts
                                                              } else {
                                                                  weekday.shifts
                                                              }
                                                              weekday
                                                                  .copy(shifts =
                                                                      updatedShifts
                                                                  )
                                                          } else {
                                                              weekday
                                                          }
                                                      })
                                                )
                                            )
                                    })
                                }
                                case None => println("no shift to paste")
                            }
                        }
                        case false =>

                    }

                }
            },
            onMouseUp --> { (e) =>
                {
                    client.copiedContent.signal
                        .now() match {
                        case Some(value) => {
                            println(
                              "pasting " + value + " to day " + day.number
                            )

                            client.dataModelVar.update(weeks => {
                                weeks
                                    .map(week =>
                                        week.copy(
                                          days = week.days.map(weekday => {
                                              if (
                                                weekday.number == day.number
                                              ) {
                                                  val updatedShifts =
                                                      if (
                                                        !weekday.shifts
                                                            .contains(value)
                                                      ) {
                                                          value :: weekday.shifts
                                                      } else {
                                                          weekday.shifts
                                                      }
                                                  weekday.copy(shifts =
                                                      updatedShifts
                                                  )
                                              } else {
                                                  weekday
                                              }
                                          })
                                        )
                                    )
                            })

                            client.copiedContent.update(shift => None)
                            dom.document
                                .getElementsByTagName("td")
                                .toList
                                .map(_.classList.remove("copied-cell"))
                        }
                        case None => println("no shift to paste")
                    }

                }
            },
            td(
              display := "flex",
              top := "0",
              justifyContent := "space-between",
              day.number,
              child <-- renderAddButton(showAddButton.signal)
            ),
            children <-- client.dataModelVar.signal.map(data => {
                renderShifts(
                  data.flatMap(week => week.getDayByNumber(day.number)).head
                )
            })
          )
        )
    }

}
