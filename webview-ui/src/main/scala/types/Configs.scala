package types

import client.AuroraClient
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.HTMLTableRowElement
import components.cells.FlagIcon
import com.raquo.laminar.api.L.{*, given}
import components.cells.UneditableDiv
import components.cells.ToggleableInput
import components.cells.CalenderDayDiv
import scala.reflect.api.*

sealed trait CellType
case object ToggleableInputType extends CellType
case object FlagIconType extends CellType
case object UneditableDivType extends CellType
case object CalenderDayDivType extends CellType

case class TableConfig[T](
    val client: AuroraClient,
    val rowIdentifier: T => String,
    val columnConfigs: List[ColumnConfig[T]]
)

case class ColumnConfig[T](
    cellType: CellType,
    headerTitle: String,
    width: String,
    cellContent: T => Day,
    fieldName: String,
    showFilterable: Boolean = false
) {
    // Remeber to implement any new cell types here
    def cellHTML(config: TableConfig[T], item: T) = {
        cellType match {
            case ToggleableInputType => ???
            case FlagIconType        => ???
            case UneditableDivType   => ???
            case CalenderDayDivType  =>
                // val week = item.asInstanceOf[Week]
                CalenderDayDiv(
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
