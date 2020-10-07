package CodeWars.kata8val.kata21

import java.util.*

fun main() {
    println(reverseSeq(5))
}

fun reverseSeq(n: Int): List<Int> {
    val list = mutableListOf<Int>()
    for (i in n downTo 1) {
      list.add(list.size, i)
    }
    return list
}

/*
fun reverseSeq(n: Int) = (n downTo 1).toList()
 */

