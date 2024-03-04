error id: file:///C:/Users/yashb/Documents/vscode-laminar-vite-extension/webview-ui/src/main/scala/types/Configs.scala:[535..536) in Input.VirtualFile("file:///C:/Users/yashb/Documents/vscode-laminar-vite-extension/webview-ui/src/main/scala/types/Configs.scala", "package types

import client.AuroraClient
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.HTMLTableRowElement
import components.cells.FlagIcon
import com.raquo.laminar.api.L.{*, given}
import components.cells.UneditableDiv
import components.cells.ToggleableInput
import scala.reflect.api.*

sealed trait CellType
case object ToggleableInputType extends CellType
case object FlagIconType extends CellType
case object UneditableDivType extends CellType

case class TableConfig[T](
    Type type: T
    val client: AuroraClient,
    val rowIdentifier: T => String,
    val columnConfigs: List[ColumnConfig[T]]
)

case class ColumnConfig[T](
    cellType: CellType,
    headerTitle: String,
    width: String,
    cellContent: T => String,
    fieldName: String,
    showFilterable: Boolean = false
) {
    // Remeber to implement any new cell types here
    def cellHTML(config: TableConfig[T], item: T) = {
        cellType match {
            case ToggleableInputType =>
                ToggleableInput(
                  cellContent(item),
                  config.client,
                  fieldName,
                  config.rowIdentifier(item)
                ).render()
            case FlagIconType =>
                FlagIcon(
                  cellContent(item),
                  config.client,
                  fieldName,
                  config.rowIdentifier(item)
                ).render()
            case UneditableDivType =>
                UneditableDiv(
                  cellContent(item),
                  config.client,
                  fieldName,
                  config.rowIdentifier(item)
                ).render()
        }
    }
}

// trait HTMLConverter[A]:
//     def tableCellToHTML(content: String): String

// given flagIconToHTML: HTMLConverter[FlagIcon] with
//     def tableCellToHTML(
//         content: String
//     ): String = "Flag icon should go here"

// given uneditableDivToHTML: HTMLConverter[UneditableDiv] with
//     def tableCellToHTML(
//         content: String
//     ): String = "uneditable div should go here"

// given ToggleableInputToHTML: HTMLConverter[ToggleableInput] with
//     def tableCellToHTML(
//         content: String
//     ): String = "Toggleable input should go here"
")
file:///C:/Users/yashb/Documents/vscode-laminar-vite-extension/webview-ui/src/main/scala/types/Configs.scala
file:///C:/Users/yashb/Documents/vscode-laminar-vite-extension/webview-ui/src/main/scala/types/Configs.scala:18: error: expected identifier; obtained colon
    Type type: T
             ^
#### Short summary: 

expected identifier; obtained colon