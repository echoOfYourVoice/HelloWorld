package CodeWars.kata8val.kata15

fun main() {
 println(summation(8))
}

fun summation(n:Int): Int {
    if (n == 0) return 0
    return n + summation(n - 1)
}

/*
object GrassHopper {
  fun summation(n: Int) = (1..n).sum()
}
 */