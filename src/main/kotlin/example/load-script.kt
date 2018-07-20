package example

import kotlinjs.common.injectScript
import kotlinjs.common.jsonAs
import org.w3c.fetch.INCLUDE
import org.w3c.fetch.RequestCredentials
import org.w3c.fetch.RequestInit
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    if (isChromeApiAvailable()) {
        val url = chrome.extension.getURL("bundle.js")
        document.injectScript(url)
    } else {
        keepAlive()
    }
}

fun keepAlive() {
    val url = "https://exchange.fcoin.com/finance/main"
    window.setInterval({
        console.log("Visit $url in background repeat to keep alive")
        window.fetch("url", jsonAs<RequestInit>().apply {
            this.credentials = RequestCredentials.INCLUDE
        }).then { response ->
            println("""status code: ${response.status}""")
        }
    }, 15000)
}

private fun isChromeApiAvailable(): Boolean {
    return js("typeof chrome != 'undefined'") as Boolean && js("typeof chrome.tabs != 'undefined'") as Boolean
}
