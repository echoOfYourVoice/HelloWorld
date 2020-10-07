package CodeWars.kata8val.kata23

fun main() {
  println(maps(intArrayOf(1, 2, 3)))
}

fun maps(x: IntArray) = x.map { it * 2 }.toIntArray()