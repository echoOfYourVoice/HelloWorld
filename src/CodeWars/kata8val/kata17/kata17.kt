package CodeWars.kata8val.kata17

fun main() {
println(digitize(35231))
}

fun digitize(n:Long) = if (n.toInt() == 0) 0 else n.toString().map { it.toString().toInt() }.reversed().toIntArray()

/*
object Kata {
  fun digitize(n:Long):IntArray {
    return n.toString().map(Character::getNumericValue).toIntArray().reversedArray()
  }
}
 */