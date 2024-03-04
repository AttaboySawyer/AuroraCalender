file:///C:/Users/yashb/Documents/vscode-laminar-vite-extension/webview-ui/src/main/scala/types/Configs.scala
### java.lang.AssertionError: assertion failed: position error, parent span does not contain child span
parent      =  extends ColumnConfig[FlagIcon, Patient] {
  def getCellHTML(item: Patient): ReactiveHtmlElement[HTMLTableRowElement] =
    null
} # -1,
parent span = <589..709>,
child       = def getCellHTML(item: Patient): ReactiveHtmlElement[HTMLTableRowElement] = null # -1,
child span  = [635..639..732]

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<WORKSPACE>\webview-ui\.bloop\livechart\bloop-bsp-clients-classes\classes-Metals-diGj0dc0RVW_XHgFoyxg4Q== [exists ], <HOME>\AppData\Local\bloop\cache\semanticdb\com.sourcegraph.semanticdb-javac.0.9.9\semanticdb-javac-0.9.9.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_sjs1_3\3.3.1\scala3-library_sjs1_3-3.3.1.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-js\scalajs-library_2.13\1.15.0\scalajs-library_2.13-1.15.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-js\scalajs-dom_sjs1_3\2.6.0\scalajs-dom_sjs1_3-2.6.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\raquo\laminar_sjs1_3\16.0.0\laminar_sjs1_3-16.0.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\io\circe\circe-core_sjs1_3\0.14.3\circe-core_sjs1_3-0.14.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\io\circe\circe-generic_sjs1_3\0.14.3\circe-generic_sjs1_3-0.14.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\io\circe\circe-parser_sjs1_3\0.14.3\circe-parser_sjs1_3-0.14.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-reflect\2.13.12\scala-reflect-2.13.12.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\olvind\scalablytyped-runtime_sjs1_3\2.4.2\scalablytyped-runtime_sjs1_3-2.4.2.jar [exists ], <HOME>\.ivy2\local\org.scalablytyped\vscode-webview_sjs1_3\1.57.5-2783c5\jars\vscode-webview_sjs1_3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-js\scalajs-javalib\1.15.0\scalajs-javalib-1.15.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-js\scalajs-scalalib_2.13\2.13.12%2B1.15.0\scalajs-scalalib_2.13-2.13.12%2B1.15.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\raquo\airstream_sjs1_3\16.0.0\airstream_sjs1_3-16.0.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\raquo\ew_sjs1_3\0.1.2\ew_sjs1_3-0.1.2.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\io\circe\circe-numbers_sjs1_3\0.14.3\circe-numbers_sjs1_3-0.14.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\typelevel\cats-core_sjs1_3\2.8.0\cats-core_sjs1_3-2.8.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\io\circe\circe-scalajs_sjs1_3\0.14.3\circe-scalajs_sjs1_3-0.14.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\app\tulz\tuplez-full-light_sjs1_3\0.4.0\tuplez-full-light_sjs1_3-0.4.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\typelevel\cats-kernel_sjs1_3\2.8.0\cats-kernel_sjs1_3-2.8.0.jar [exists ]
Options:
-scalajs -Xsemanticdb -sourceroot <WORKSPACE>\webview-ui


action parameters:
offset: 646
uri: file:///C:/Users/yashb/Documents/vscode-laminar-vite-extension/webview-ui/src/main/scala/types/Configs.scala
text:
```scala
package types

import client.AuroraClient
import components.cells.AuroraCellElement
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.HTMLTableRowElement
import components.cells.FlagIcon

case class TableConfig[A](
    val client: AuroraClient,
    val columnConfigs: List[ColumnConfig[_, _]]
)

case class ColumnConfig[AuroraCellElement, A](
    headerTitle: String,
    width: String
    // fieldName: String,
    // item: Patient
) {
    def getCellHTML(item: A): ReactiveHtmlElement[HTMLTableRowElement]
}

object ColumnConfig:
    given ColumnConfig[FlagIcon, Patient] with
        def getCell@@HTML(item: Patient): ReactiveHtmlElement[HTMLTableRowElement] = 
            

    given ColumnConfig[AuroraCellElement, Patient] with
        def compare(x: String, y: String): Int = x.compareTo(y)
end Comparator

```



#### Error stacktrace:

```
scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:8)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:175)
	dotty.tools.dotc.ast.Positioned.check$1$$anonfun$3(Positioned.scala:205)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:205)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:226)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:200)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:226)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:200)
	dotty.tools.dotc.ast.Positioned.check$1$$anonfun$3(Positioned.scala:205)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:205)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:226)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:200)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:226)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:200)
	dotty.tools.dotc.ast.Positioned.check$1$$anonfun$3(Positioned.scala:205)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:205)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:226)
	dotty.tools.dotc.parsing.Parser.parse$$anonfun$1(ParserPhase.scala:38)
	dotty.tools.dotc.parsing.Parser.parse$$anonfun$adapted$1(ParserPhase.scala:39)
	scala.Function0.apply$mcV$sp(Function0.scala:42)
	dotty.tools.dotc.core.Phases$Phase.monitor(Phases.scala:440)
	dotty.tools.dotc.parsing.Parser.parse(ParserPhase.scala:39)
	dotty.tools.dotc.parsing.Parser.runOn$$anonfun$1(ParserPhase.scala:48)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.parsing.Parser.runOn(ParserPhase.scala:48)
	dotty.tools.dotc.Run.runPhases$1$$anonfun$1(Run.scala:246)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1321)
	dotty.tools.dotc.Run.runPhases$1(Run.scala:262)
	dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:270)
	dotty.tools.dotc.Run.compileUnits$$anonfun$adapted$1(Run.scala:279)
	dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:67)
	dotty.tools.dotc.Run.compileUnits(Run.scala:279)
	dotty.tools.dotc.Run.compileSources(Run.scala:194)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:165)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.PcDefinitionProvider.definitions(PcDefinitionProvider.scala:44)
	scala.meta.internal.pc.PcDefinitionProvider.definitions(PcDefinitionProvider.scala:34)
	scala.meta.internal.pc.ScalaPresentationCompiler.definition$$anonfun$1(ScalaPresentationCompiler.scala:156)
```
#### Short summary: 

java.lang.AssertionError: assertion failed: position error, parent span does not contain child span
parent      =  extends ColumnConfig[FlagIcon, Patient] {
  def getCellHTML(item: Patient): ReactiveHtmlElement[HTMLTableRowElement] =
    null
} # -1,
parent span = <589..709>,
child       = def getCellHTML(item: Patient): ReactiveHtmlElement[HTMLTableRowElement] = null # -1,
child span  = [635..639..732]