package CodeWars.kata8val.kata8

fun main() {
    println(expressionsMatter(2, 1, 2))
    println(expressionsMatter(1, 1, 1))
    println(expressionsMatter(2, 1, 1))
    println(expressionsMatter(1, 2, 3))
    println(expressionsMatter(1, 3, 1))
    println(expressionsMatter(2, 2, 2))
}

fun expressionsMatter(a : Int, b : Int, c : Int) : Int {
    return maxOf(maxOf(a * (b + c), a * b * c), maxOf((a + b) * c, a + b + c))
}

/*
fun expressionsMatter(a : Int, b : Int, c : Int) = intArrayOf(a + b + c, a + b * c, a * b * c, a * b + c, (a + b) * c, a * (b + c)).ch02.max()
 */
