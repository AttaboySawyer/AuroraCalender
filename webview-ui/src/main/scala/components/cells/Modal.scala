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
import org.scalajs.dom.HTMLDivElement
import org.scalajs.dom.HTMLInputElement
import types.Shift

case class Modal(
) {

    val dayNumberVar = Var("undefined")
    val dayNameVar = Var("undefined")
    val monthVar = Var("undefined")

    def updateDayNumberVar(newNumber: String) = {
        dayNumberVar.update(num => newNumber)
    }
    def updateDayNameVar(newName: String) = {
        dayNameVar.update(name => newName)
    }
    def updateMonthVar(newMonth: String) = {
        monthVar.update(month => newMonth)
    }

    def render(client: AuroraClient) = {
        div(
          idAttr := "myModal",
          className := "modal",
          div(
            className := "modal-content",
            span(
              className := "close",
              "x",
              onClick --> { (e) =>
                  {
                      val modal = dom.document
                          .getElementById("myModal")
                          .asInstanceOf[HTMLDivElement];
                      modal.style.display = "none"
                  }
              }
            ),
            h2(
              color := "black",
              child <-- dayNumberVar.signal.flatMap(dayNumber => {
                  dayNameVar.signal.flatMap(dayName => {
                      monthVar.signal.map(month => {
                          "Add Shift to " + dayName + ", " + month + " " + dayNumber + ", 2024"
                      })
                  })
              })
            ),
            // TODO change this to form when using routes later
            div(
              display := "flex",
              flexDirection := "column",
              alignItems := "left",
              label(forId := "name", color := "black", "Name: "),
              input(idAttr := "name", maxWidth := "300px"),
              br(),
              label(forId := "color", color := "black", "Color: "),
              input(idAttr := "color", `type` := "color", value := "#55DDD4"),
              br(),
              label(forId := "startTime", color := "black", "Start Time: "),
              input(
                idAttr := "startTime",
                `type` := "time",
                maxWidth := "100px"
              ),
              br(),
              label(forId := "endTime", color := "black", "End Time: "),
              input(idAttr := "endTime", `type` := "time", maxWidth := "100px"),
              br(),
              button(
                "submit",
                onClick --> { (e) =>
                    {
                        println("Submitting: ")
                        val name = dom.document
                            .getElementById("name")
                            .asInstanceOf[HTMLInputElement]
                            .value
                        val color = dom.document
                            .getElementById("color")
                            .asInstanceOf[HTMLInputElement]
                            .value
                        val startTime = dom.document
                            .getElementById("startTime")
                            .asInstanceOf[HTMLInputElement]
                            .value
                        val endTime = dom.document
                            .getElementById("endTime")
                            .asInstanceOf[HTMLInputElement]
                            .value

                        client.dataModelVar.update(weeks => {
                            weeks
                                .map(week =>
                                    week.copy(
                                      days = week.days.map(weekday => {
                                          if (
                                            weekday.number == dayNumberVar.now()
                                          ) {
                                              val updatedShifts =
                                                  Shift(
                                                    name,
                                                    color,
                                                    startTime,
                                                    endTime
                                                  ) :: weekday.shifts

                                              weekday
                                                  .copy(shifts = updatedShifts)
                                          } else {
                                              weekday
                                          }
                                      })
                                    )
                                )
                            // })
                        })
                        val modal = dom.document
                            .getElementById("myModal")
                            .asInstanceOf[HTMLDivElement];
                        modal.style.display = "none"
                    }
                }
              )
            )
          )
        )
    }

    // def renderModalContent() = {
    //     val modalOption = Option(
    //       dom.document
    //           .getElementById("myModal")
    //           .asInstanceOf[HTMLDivElement]
    //     );

    //     println(modalOption)
    //     modalOption match {
    //         case Some(modal) => {

    //         }
    //         case None => div("no modal, something is wrong...")
    //     }

    // }
}
