#!/usr/bin/env kotlin

import java.io.File
import kotlin.text.appendLine
import kotlin.text.lowercase
import kotlin.text.toRegex

val colorsKtFile = File("app/src/main/java/com/prototype/compose_figma_app/ui/theme/Color.kt")
val colorsXmlFile = File("app/src/main/res/values/colors.xml")
val colorRegex = """val (\w+) = Color\(0x([0-9A-F]{8})\)""".toRegex()
val colors = kotlin.collections.mutableListOf<Pair<String, String>>()
colorsKtFile.forEachLine { line ->
    val matchResult = colorRegex.find(line)
    matchResult?.let {
        val (name, hex) = it.destructured
        colors.add(name to "#$hex")
    }
}
val xmlContent = kotlin.text.buildString {
    appendLine("""<?xml version="1.0" encoding="utf-8"?>""")
    appendLine("""<resources>""")
    colors.forEach { (name, value) ->
        appendLine("""    <color name="${name.toSnakeCase()}">${value}</color>""")
    }
    appendLine("""</resources>""")
}
colorsXmlFile.writeText(xmlContent)
println("Generated colors.xml with ${colors.size} colors.")
// Extension function to convert CamelCase to snake_case
fun String.toSnakeCase() = replace(Regex("([a-z])([A-Z])"), "$1_$2").lowercase()