package ch03.colletions

import strings.lastChar
import java.lang.StringBuilder

/*
Можно поменять имя импортируемого класса или функции, добавив
ключевое слово as:
import strings . lastChar as last
 */

fun main() {
println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}