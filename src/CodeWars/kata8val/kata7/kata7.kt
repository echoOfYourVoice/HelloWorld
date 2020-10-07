package CodeWars.kata8val.kata7

fun main() {
println(subtractSum(1))
}

fun subtractSum(n: Int): String {
    var result = 0;
    val n1: Int
    if (n < 10) n1 = n * 10
    else n1 = n
    for (c in  n.toString()) {
        val digit = c - '0'
        result += digit
    }
    result = n1 - result
    val fruit = when {
        result == 1 -> "kiwi"
        result == 2 -> "pear"
        result == 5 -> "melon"
        result == 8 -> "pineapple"
        result == 9 -> "apple"
        result == 11 -> "cucumber"
        result == 14 -> "orange"
        result == 15 -> "grape"
        result == 20 -> "cherry"
        else -> subtractSum(result)
    }
    return fruit
}

