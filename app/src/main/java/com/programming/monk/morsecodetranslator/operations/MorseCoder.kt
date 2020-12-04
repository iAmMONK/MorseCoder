package com.programming.monk.morsecodetranslator.operations

class MorseCoder {
    var codedMessage = ""
        private set
    var errSymbols: String? = null
        private set
    var errorExistence = false
        private set

    fun codeToMorse(messageToCode: String): String {
        codedMessage = ""
        errSymbols = ""
        errorExistence = false
        messageToCode.forEach {
            when (it) {
                'a' -> codedMessage = "$codedMessage.- "
                'b' -> codedMessage = "$codedMessage-... "
                'c' -> codedMessage = "$codedMessage-.-. "
                'd' -> codedMessage = "$codedMessage-.. "
                'e' -> codedMessage = "$codedMessage. "
                'f' -> codedMessage = "$codedMessage..-. "
                'g' -> codedMessage = "$codedMessage--. "
                'h' -> codedMessage = "$codedMessage.... "
                'i' -> codedMessage = "$codedMessage.. "
                'j' -> codedMessage = "$codedMessage.--- "
                'k' -> codedMessage = "$codedMessage-.- "
                'l' -> codedMessage = "$codedMessage.-.. "
                'm' -> codedMessage = "$codedMessage-- "
                'n' -> codedMessage = "$codedMessage-. "
                'o' -> codedMessage = "$codedMessage--- "
                'p' -> codedMessage = "$codedMessage.--. "
                'q' -> codedMessage = "$codedMessage--.- "
                'r' -> codedMessage = "$codedMessage.-. "
                's' -> codedMessage = "$codedMessage... "
                't' -> codedMessage = "$codedMessage- "
                'u' -> codedMessage = "$codedMessage..- "
                'v' -> codedMessage = "$codedMessage...- "
                'w' -> codedMessage = "$codedMessage.-- "
                'x' -> codedMessage = "$codedMessage-..- "
                'y' -> codedMessage = "$codedMessage-.-- "
                'z' -> codedMessage = "$codedMessage--.. "
                '1' -> codedMessage = "$codedMessage.---- "
                '2' -> codedMessage = "$codedMessage..--- "
                '3' -> codedMessage = "$codedMessage...-- "
                '4' -> codedMessage = "$codedMessage....- "
                '5' -> codedMessage = "$codedMessage..... "
                '6' -> codedMessage = "$codedMessage-.... "
                '7' -> codedMessage = "$codedMessage--... "
                '8' -> codedMessage = "$codedMessage---.. "
                '9' -> codedMessage = "$codedMessage----. "
                '0' -> codedMessage = "$codedMessage----- "
                ' ' -> {}
                '\n' -> { }
                else -> {
                    errorExistence = true
                    errSymbols += it
                }
            }
        }
        return codedMessage
    }

    fun decodeFromMorse(messageToCode: String): String {
        var message = messageToCode
        message = "$message "
        codedMessage = ""
        errSymbols = ""
        errorExistence = false
        message.split(' ').forEach {
            when (it) {
                ".-" -> codedMessage += "a"
                "-..." -> codedMessage += "b"
                "-.-." -> codedMessage += "c"
                "-.." -> codedMessage += "d"
                "." -> codedMessage += "e"
                "..-." -> codedMessage += "f"
                "--." -> codedMessage += "g"
                "...." -> codedMessage += "h"
                ".." -> codedMessage += "i"
                ".---" -> codedMessage += "j"
                "-.-" -> codedMessage += "k"
                ".-.." -> codedMessage += "l"
                "--" -> codedMessage += "m"
                "-." -> codedMessage += "n"
                "---" -> codedMessage += "o"
                ".--." -> codedMessage += "p"
                "--.-" -> codedMessage += "q"
                ".-." -> codedMessage += "r"
                "..." -> codedMessage += "s"
                "-" -> codedMessage += "t"
                "..-" -> codedMessage += "u"
                "...-" -> codedMessage += "v"
                ".--" -> codedMessage += "w"
                "-..-" -> codedMessage += "x"
                "-.--" -> codedMessage += "y"
                "--.." -> codedMessage += "z"
                ".----" -> codedMessage += "1"
                "..---" -> codedMessage += "2"
                "...--" -> codedMessage += "3"
                "....-" -> codedMessage += "4"
                "....." -> codedMessage += "5"
                "-...." -> codedMessage += "6"
                "--..." -> codedMessage += "7"
                "---.." -> codedMessage += "8"
                "----." -> codedMessage += "9"
                "-----" -> codedMessage += "0"
                "/" -> codedMessage += " "
                " " -> {
                }
                "" -> {
                }
                else -> {
                    errorExistence = true
                    errSymbols = "$errSymbols$it "
                }
            }
        }
        return codedMessage
    }
}