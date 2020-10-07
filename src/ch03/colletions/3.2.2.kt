package ch03.colletions

import strings.joinToStringWithParam

fun main() {
    val list = listOf(1, 2, 3)
    joinToStringWithParam(list, ", ", "", "")
    joinToStringWithParam(list)
    joinToStringWithParam(list, "; ")
    joinToStringWithParam(list, postfix = ";", prefix = "# ")

}
