package kotlinvsjava.samples

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HtmlDslTest {
    @Test
    fun testHtmlDsl() {
        val document = html {
            head {
                title("Kotlin DSL Example")
            }
            body {
                h1("Welcome to Kotlin DSL")
                p("This is a simple example of a Kotlin DSL.")
            }
        }

        println(document)
        assertThat(document.toString()).contains("<h1>Welcome to Kotlin DSL</h1>")
    }
}

fun html(init: Html.() -> Unit): Html {
    return Html().apply(init)
}

@DslMarker
annotation class HtmlDsl

@HtmlDsl
class Html {
    private val children = mutableListOf<HtmlElement>()

    fun head(init: Head.() -> Unit) {
        children.add(Head().apply(init))
    }

    fun body(init: Body.() -> Unit) {
        children.add(Body().apply(init))
    }

    override fun toString() = children.joinToString("\n")
}

interface HtmlElement

@HtmlDsl
class Head : HtmlElement {
    private val children = mutableListOf<String>()

    fun title(text: String) {
        children.add("<title>$text</title>")
    }

    override fun toString() = "<head>\n${children.joinToString("\n")}\n</head>"
}

@HtmlDsl
class Body : HtmlElement {
    private val children = mutableListOf<String>()

    fun h1(text: String) {
        children.add("<h1>$text</h1>")
    }

    fun p(text: String) {
        children.add("<p>$text</p>")
    }

    override fun toString() = "<body>\n${children.joinToString("\n")}\n</body>"
}