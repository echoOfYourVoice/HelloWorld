package CodeWars.kata8val.kata11

fun main() {
println(sum(intArrayOf(1, 2, 3, 4, 5)))
}

fun sum(numbers: IntArray) = numbers.sumBy {
    when {
        it < 0 -> 0
        else -> it
    }
}

/*
fun sum(numbers: IntArray) = numbers.filter { it > 0 }.sum()
 */