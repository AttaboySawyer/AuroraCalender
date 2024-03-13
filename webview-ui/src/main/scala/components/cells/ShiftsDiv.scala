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

case class ShiftsDiv(
    day: Day,
    client: AuroraClient
) {

    def render() = {
        day.shifts
            .sortBy(_.worker)
            .map(shift => {
                var timeoutId: SetTimeoutHandle = setTimeout(0)({})
                clearTimeout(timeoutId)
                td(
                  title := shift.startTime + "-" + shift.endTime,
                  shift.worker,
                  className := "shift-" + shift.worker,
                  backgroundColor := shift.color,
                  draggable := true,
                  onMouseOver --> { (e) =>
                      {
                          timeoutId = setTimeout(1000) {
                              val otherShiftCells = dom.document
                                  .querySelectorAll("td[class^='shift-']")
                                  .filterNot(
                                    _.classList
                                        .contains("shift-" + shift.worker)
                                  )
                              otherShiftCells.map(cell => {
                                  cell.asInstanceOf[HTMLTableCellElement]
                                      .style
                                      .opacity = "0.25"
                              })
                          }
                      }
                  },
                  onMouseLeave --> { (e) =>
                      {
                          clearTimeout(timeoutId)
                          val otherShiftCells = dom.document
                              .querySelectorAll("td[class^='shift-']")
                              .filterNot(
                                _.classList.contains("shift-" + shift.worker)
                              )
                          otherShiftCells.toList.map(cell => {
                              cell.asInstanceOf[HTMLTableCellElement]
                                  .style
                                  .opacity = "1"
                          })
                      }
                  },
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
                                              .asInstanceOf[
                                                HTMLTableCellElement
                                              ]
                                              .innerText,
                                          shift.color,
                                          shift.startTime,
                                          shift.endTime
                                        )
                                      )
                                  )
                                  println(
                                    "copying " + e.target
                                        .asInstanceOf[HTMLTableCellElement]
                                        .innerText + " from day " + day.number
                                  )
                              }
                              case false =>
                                  e.altKey match {
                                      case true =>
                                          dom.document
                                              .getElementsByTagName("td")
                                              .toList
                                              .map(
                                                _.classList
                                                    .remove("copied-cell")
                                              )
                                          e.target
                                              .asInstanceOf[
                                                HTMLTableCellElement
                                              ]
                                              .classList
                                              .add("copied-cell")
                                          client.copiedContent.update(content =>
                                              Some(
                                                Shift(
                                                  e.target
                                                      .asInstanceOf[
                                                        HTMLTableCellElement
                                                      ]
                                                      .innerText,
                                                  shift.color,
                                                  shift.startTime,
                                                  shift.endTime
                                                )
                                              )
                                          )
                                          println(
                                            "continuous copying " + e.target
                                                .asInstanceOf[
                                                  HTMLTableCellElement
                                                ]
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

}
