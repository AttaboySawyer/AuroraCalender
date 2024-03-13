package components.toolbar

import org.scalajs.dom
import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom.HTMLTableCellElement
import org.scalajs.dom.MouseEvent
// import components.button.AddButton

import client.AuroraClient
import components.AuroraElement
import types.TableConfig

case class Toolbar[A](config: TableConfig[A]) extends AuroraElement {

    val searchByOption: List[String] = config.columnConfigs.map(_.headerTitle)

    val showOptions: List[String] =
        config.columnConfigs.filter(_.showFilterable).map(_.headerTitle)

    def render(): Element = {
        div(
          className := "toolbar",
          h2("March")
          //   Text("Search By:", ml = "").render(),
          //   Search("All" :: searchByOption).render(),
          //   Text("Show:").render(),
          //   Select("All" :: showOptions).render()
          //   AddButton("➕", config.client).render()
        )
    }

}
