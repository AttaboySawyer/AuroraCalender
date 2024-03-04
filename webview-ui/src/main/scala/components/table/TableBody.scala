package components.table

import components.AuroraElement
import com.raquo.laminar.api.L.{*, given}

import types.OpenFileMessage
import scala.scalajs.js.JSON
import scala.scalajs.js
import io.circe.parser._
import io.circe.generic.auto._
import utilities.JsonImplicits._
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.HTMLTableRowElement
import client.AuroraClient
import components.cells.FlagIcon
import components.cells.UneditableDiv
import components.cells.ToggleableInput
import components.utils.VscodeAPI.getVscodeApi
import types.TableConfig
import types.{given}

case class TableBody[T](config: TableConfig[T]) extends AuroraElement {

    def render(): Element = {

        tbody(
          // Fetch the data on component mount, update table
          FetchStream.get(config.client.GETUrl) --> { responseText =>
              config.client.populateTable(responseText)
          },
          idAttr := "myTableBody",
          children <-- config.client.dataModelVar.signal.map(data =>
              data.map { item =>
                  val children = config.columnConfigs.map(column => {
                      column.cellHTML(
                        config,
                        item.asInstanceOf[T]
                      )
                  })
                  tr(
                    width := "100%",
                    onClick --> { (e) =>
                        // getVscodeApi().postMessage(
                        //   OpenFileMessage(
                        //     item.firstName,
                        //     item.lastName,
                        //     item.unitNumber
                        //   )
                        //       .toJson()
                        // )
                    },
                    children
                  )
              }
          )
        )
    }

}
