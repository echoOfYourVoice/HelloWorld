package CodeWars.kata8val.kata22

fun main() {
println(century(1705))
}

fun century(number: Int) = Math.ceil(number.toDouble() / 100).toInt()

/*
fun century(number: Int) = (number +99) / 100
 */