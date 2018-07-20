package example

import chrome.tabs.QueryInfo
import kotlinjs.common.injectScript
import kotlinjs.common.jsonAs
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    document.injectScript("functions-in-fcoin.js")
}

