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
import scala.scalajs.js.timers.{SetTimeoutHandle, setTimeout, clearTimeout}
import org.scalajs.dom.HTMLDivElement

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
                      val modal = dom.document
                          .getElementById("myModal")
                          .asInstanceOf[HTMLDivElement];
                      modal.style.display = "block"
                      client.modal.updateMonthVar(day.month)
                      client.modal.updateDayNameVar(fieldName.capitalize)
                      client.modal.updateDayNumberVar(day.number)
                  })
                )
            case false => div()
        }
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
            onMouseEnter --> handleDayMouseEnter,
            onMouseLeave --> (e => showAddButton.update(bool => false)),
            onMouseUp --> handleDayMouseUp,
            td(
              display := "flex",
              top := "0",
              backgroundColor := "rgb(43, 43, 43)",
              justifyContent := "space-between",
              day.number,
              child <-- renderAddButton(showAddButton.signal)
            ),
            children <-- client.dataModelVar.signal.map(data => {
                ShiftsDiv(
                  data.flatMap(week => week.getDayByNumber(day.number)).head,
                  client
                ).render()
            })
          )
        )
    }

    def handleDayMouseEnter(e: MouseEvent) = {
        showAddButton.update(bool => true)
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
                                      days = week.days.map(weekday => {
                                          if (weekday.number == day.number) {
                                              val updatedShifts =
                                                  if (
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
                                                  .copy(shifts = updatedShifts)
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

    def handleDayMouseUp(e: MouseEvent) = {
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
                                  if (weekday.number == day.number) {
                                      val updatedShifts =
                                          if (
                                            !weekday.shifts
                                                .contains(value)
                                          ) {
                                              value :: weekday.shifts
                                          } else {
                                              weekday.shifts
                                          }
                                      weekday.copy(shifts = updatedShifts)
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
                    .head
            }
            case None => println("no shift to paste")
        }
    }
}
