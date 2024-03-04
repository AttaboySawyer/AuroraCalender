error id: file:///C:/Users/yashb/Documents/vscode-laminar-vite-extension/webview-ui/src/main/scala/components/Table.scala:[1205..1206) in Input.VirtualFile("file:///C:/Users/yashb/Documents/vscode-laminar-vite-extension/webview-ui/src/main/scala/components/Table.scala", "package components

import org.scalajs.dom
import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom.HTMLTableCellElement
import org.scalajs.dom.MouseEvent
import models.*
import utilities.SortGrid.ascendingSort

var ascendingSort = true
def setAscendingSort(value: Boolean): Unit = {
  ascendingSort = value
}

def onHeaderClick(event: dom.Event): Unit = {
    val clickedHeader = event.currentTarget.asInstanceOf[dom.html.TableCell]
    val columnIndex = clickedHeader.cellIndex

    // Extract the table rows and convert them to a list
    val tableRows = dom.document.querySelectorAll("tbody tr")
    val rowsList = List.tabulate(tableRows.length)(i => tableRows.item(i))

    // Sort the rows based on the content of the clicked column using the sortGrid function
    val sortedRows = rowsList.sortBy { row =>
      val cellValue = row.children.item(columnIndex).textContent
      cellValue
    }(sortGrid)

    // Clear the table body
    val tableBody = dom.document.querySelector("tbody")
    tableBody.innerHTML = ""

    // Append the sorted rows to the table body
    sortedRows.foreach(tableBody.appendChild)
  }
    // Your sortGrid function
   def @FunctionalInterface sortGrid(a: String, b: String): Int = {
    val lowerA = a.toLowerCase
    val lowerB = b.toLowerCase

    if (lowerA < lowerB) -1
    else if (lowerA > lowerB) 1
    else 0
  }

def renderDataTable(model: Model): Element =
  div(
    className := "table-container",
    table(
      idAttr := "myTable",
      thead(
        tr(
            model.headers.map(header => {
                th(header)
            }),
        )
      ),
      tbody(
        children <-- model.dataSignal.map(data => data.map { item =>
          renderDataItem(item)
        }),
      ),
      tfoot(tr(
        td(button("➕")),
        td(),
        td(),
        td(child.text <-- model.dataSignal.map(data => "%.2f".format(data.map(_.fullPrice).sum))),
      )),
    )
  )
end renderDataTable

def renderDataItem(item: RowData): Element =

    val row = item.getAsHTML()
    row

end renderDataItem")
file:///C:/Users/yashb/Documents/vscode-laminar-vite-extension/webview-ui/src/main/scala/components/Table.scala
file:///C:/Users/yashb/Documents/vscode-laminar-vite-extension/webview-ui/src/main/scala/components/Table.scala:37: error: expected identifier; obtained at
   def @FunctionalInterface sortGrid(a: String, b: String): Int = {
       ^
#### Short summary: 

expected identifier; obtained at