package CodeWars.kata8val.kata9

fun main() {
 println(past(0, 1, 1))
}

fun past(h: Int, m: Int, s: Int): Int {
return h * 60 * 60 * 1000 + m * 60 * 1000 + s * 1000
}

/*
fun past(h: Int, m: Int, s: Int) = ((h * 60 + m) * 60 + s) * 1000
 */