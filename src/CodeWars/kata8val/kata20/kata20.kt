package CodeWars.kata8val.kata20

fun main() {
    println(sum(listOf(5, "5")))
}

public fun sum(mixed: List<Any>) = mixed.sumBy { it.toString().toInt() }