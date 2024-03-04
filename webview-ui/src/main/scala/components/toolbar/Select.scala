package components.toolbar

import components.AuroraElement
import com.raquo.laminar.api.L.{*, given}

case class Select(options: List[String]) extends AuroraElement {

    val optionsVar = Var(initial = options.headOption.getOrElse("All"))

    def render(): Element = {
        select(
          onChange.mapToValue --> optionsVar.writer,
          value <-- optionsVar.signal,
          options.map(opt => option(value(opt), opt))
        )
    }

}
