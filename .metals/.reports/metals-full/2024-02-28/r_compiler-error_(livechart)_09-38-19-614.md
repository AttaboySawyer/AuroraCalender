file:///C:/Users/yashb/Documents/vscode-laminar-vite-extension/webview-ui/src/main/scala/components/toolbar/Toolbar.scala
### java.nio.file.InvalidPathException: Illegal char <:> at index 3: jar:file:///C:/Users/yashb/AppData/Local/Coursier/cache/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12-sources.jar!/scala/collection/immutable/List.scala

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<WORKSPACE>\webview-ui\.bloop\livechart\bloop-bsp-clients-classes\classes-Metals-Dm8gbpJwSvaAWN2g60GgIw== [exists ], <HOME>\AppData\Local\bloop\cache\semanticdb\com.sourcegraph.semanticdb-javac.0.9.9\semanticdb-javac-0.9.9.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_sjs1_3\3.3.1\scala3-library_sjs1_3-3.3.1.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-js\scalajs-library_2.13\1.15.0\scalajs-library_2.13-1.15.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-js\scalajs-dom_sjs1_3\2.6.0\scalajs-dom_sjs1_3-2.6.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\raquo\laminar_sjs1_3\16.0.0\laminar_sjs1_3-16.0.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\io\circe\circe-core_sjs1_3\0.14.3\circe-core_sjs1_3-0.14.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\io\circe\circe-generic_sjs1_3\0.14.3\circe-generic_sjs1_3-0.14.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\io\circe\circe-parser_sjs1_3\0.14.3\circe-parser_sjs1_3-0.14.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-reflect\2.13.12\scala-reflect-2.13.12.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\olvind\scalablytyped-runtime_sjs1_3\2.4.2\scalablytyped-runtime_sjs1_3-2.4.2.jar [exists ], <HOME>\.ivy2\local\org.scalablytyped\vscode-webview_sjs1_3\1.57.5-2783c5\jars\vscode-webview_sjs1_3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-js\scalajs-javalib\1.15.0\scalajs-javalib-1.15.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-js\scalajs-scalalib_2.13\2.13.12%2B1.15.0\scalajs-scalalib_2.13-2.13.12%2B1.15.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\raquo\airstream_sjs1_3\16.0.0\airstream_sjs1_3-16.0.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\raquo\ew_sjs1_3\0.1.2\ew_sjs1_3-0.1.2.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\io\circe\circe-numbers_sjs1_3\0.14.3\circe-numbers_sjs1_3-0.14.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\typelevel\cats-core_sjs1_3\2.8.0\cats-core_sjs1_3-2.8.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\io\circe\circe-scalajs_sjs1_3\0.14.3\circe-scalajs_sjs1_3-0.14.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\app\tulz\tuplez-full-light_sjs1_3\0.4.0\tuplez-full-light_sjs1_3-0.4.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\typelevel\cats-kernel_sjs1_3\2.8.0\cats-kernel_sjs1_3-2.8.0.jar [exists ]
Options:
-scalajs -Xsemanticdb -sourceroot <WORKSPACE>\webview-ui


action parameters:
offset: 572
uri: file:///C:/Users/yashb/Documents/vscode-laminar-vite-extension/webview-ui/src/main/scala/components/toolbar/Toolbar.scala
text:
```scala
package components.toolbar

import org.scalajs.dom
import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom.HTMLTableCellElement
import org.scalajs.dom.MouseEvent
// import models.*
import components.button.AddButton

import client.AuroraClient
import components.AuroraElement
import types.TableConfig

case class Toolbar[A](config: TableConfig[A]) extends AuroraElement {

    val searchByOption: List[String] = config.columnConfigs.map(_.headerTitle)

    val showOptions: List[String] =
        config.columnConfigs.filter(_.showFilterable).ma@@

    def render(): Element = {
        div(
          className := "toolbar",
          Text("Search By:", ml = "").render(),
          Search("All" :: searchByOption).render(),
          Text("Show:").render(),
          Select("All" :: showOptions).render(),
          AddButton("➕", config.client).render()
        )
    }

}

```



#### Error stacktrace:

```
java.base/sun.nio.fs.WindowsPathParser.normalize(WindowsPathParser.java:182)
	java.base/sun.nio.fs.WindowsPathParser.parse(WindowsPathParser.java:153)
	java.base/sun.nio.fs.WindowsPathParser.parse(WindowsPathParser.java:77)
	java.base/sun.nio.fs.WindowsPath.parse(WindowsPath.java:92)
	java.base/sun.nio.fs.WindowsFileSystem.getPath(WindowsFileSystem.java:229)
	java.base/java.nio.file.Path.of(Path.java:147)
	java.base/java.nio.file.Paths.get(Paths.java:69)
	scala.meta.io.AbsolutePath$.apply(AbsolutePath.scala:60)
	scala.meta.internal.metals.MetalsSymbolSearch.$anonfun$definitionSourceToplevels$2(MetalsSymbolSearch.scala:62)
	scala.Option.map(Option.scala:242)
	scala.meta.internal.metals.MetalsSymbolSearch.definitionSourceToplevels(MetalsSymbolSearch.scala:61)
	scala.meta.internal.pc.completions.CaseKeywordCompletion$.sortSubclasses(MatchCaseCompletions.scala:312)
	scala.meta.internal.pc.completions.CaseKeywordCompletion$.matchContribute(MatchCaseCompletions.scala:260)
	scala.meta.internal.pc.completions.Completions.advancedCompletions(Completions.scala:385)
	scala.meta.internal.pc.completions.Completions.completions(Completions.scala:183)
	scala.meta.internal.pc.completions.CompletionProvider.completions(CompletionProvider.scala:86)
	scala.meta.internal.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:146)
```
#### Short summary: 

java.nio.file.InvalidPathException: Illegal char <:> at index 3: jar:file:///C:/Users/yashb/AppData/Local/Coursier/cache/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12-sources.jar!/scala/collection/immutable/List.scala