package ch03.colletions

import strings.joinToString

fun main() {
    val list = listOf(1, 2, 3)
    println(list)
    println(list.joinToString(separator = "; ", prefix = "(", postfix = ")"))
    /*
    lntettiJ IDEA может автоматически обновлять имена аргументов при изменении имен
параметров вызываемой функции. Для этого используйте операции Rename or Change
Signature (Переименовать или изменить сигнатуру) вместо изменения имен вручную.
     */
    list.joinToString(separator = " ", prefix = " ", postfix = ".")
}

