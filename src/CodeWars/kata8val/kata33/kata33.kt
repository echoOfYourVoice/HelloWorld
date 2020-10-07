package CodeWars.kata8val.kata33

fun main() {

}

fun feast(beast: String, dish: String) = beast[0] == dish[0] && beast[beast.length - 1] == dish[dish.length - 1]

/*
fun feast(beast: String, dish: String) = beast.first() == dish.first() && beast.last() == dish.last()
 */