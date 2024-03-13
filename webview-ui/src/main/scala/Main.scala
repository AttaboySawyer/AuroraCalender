import org.scalajs.dom
import com.raquo.laminar.api.L.{*, given}
import typings.vscodeWebview.mod.global.*
import types.BasicMessage
import scala.scalajs.js

import client.AuroraClient
import components.toolbar.Toolbar
import components.table.Table
import types.TableConfig
import types.ColumnConfig
import types.{given}
import types.*

import configs.CalenderConfig.config

import components.cells._

@main
def Main(): Unit = {

    val tableConfig = config
    renderOnDomContentLoaded(
      dom.document.body,
      div(
        width := "100%",
        div(
          width := "100%",
          Toolbar[Week](tableConfig).render(),
          Table[Week](tableConfig).render()
        ),
        tableConfig.client.modal.render(tableConfig.client)
      )
    )
}
end Main
