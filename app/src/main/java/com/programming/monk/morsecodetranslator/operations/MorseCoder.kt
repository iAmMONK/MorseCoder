package com.programming.monk.morsecodetranslator.operations

class MorseCoder {
    private val encodingMap = mapOf(
            'a' to ".-",
            'b' to "-...",
            'c' to "-.-.",
            'd' to "-..",
            'e' to ".",
            'f' to "..-.",
            'g' to "--.",
            'h' to "....",
            'i' to "..",
            'j' to ".---",
            'k' to "-.-",
            'l' to ".-..",
            'm' to "--",
            'n' to "-.",
            'o' to "---",
            'p' to ".--.",
            'q' to "--.-",
            'r' to ".-.",
            's' to "...",
            't' to "-",
            'u' to "..-",
            'v' to "...-",
            'w' to ".--",
            'x' to "-..-",
            'y' to "-.--",
            'z' to "--..",
            '1' to ".----",
            '2' to "..---",
            '3' to "...--",
            '4' to "....-",
            '5' to ".....",
            '6' to "-....",
            '7' to "--...",
            '8' to "---..",
            '9' to "----.",
            '0' to "-----",
            ' ' to "/"
    )

    private val decodingMap = encodingMap.entries.associateBy({ it.value }) { it.key }

    fun encode(input: String): String {
        val output = StringBuilder()
        input.trim().forEach {
            encodingMap[it.lowercaseChar()]?.let { code -> output.append("$code ") }
        }
        return output.toString()
    }

    fun decode(input: String): String {
        val output = StringBuilder()
        input.trim().split(' ').forEach {
            decodingMap[it.trim()]?.let { code -> output.append(code) }
        }
        return output.toString()
    }
}