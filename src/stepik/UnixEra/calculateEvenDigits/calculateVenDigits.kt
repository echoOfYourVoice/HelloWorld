package stepik.UnixEra.calculateEvenDigits

fun main() {
println(calculateEvenDigits("660308340"))
}

fun calculateEvenDigits(input:String): Int {
    var result = 0
    for (c in input) {
        if ((c - '0') % 2 == 0) result += (c - '0')
    }
    return result
}
// Ты сделал почти также, но забыл конечный результат привести к String перед toInt() почти красава
/*
fun calculateEvenDigits(input:String) = input.filter { it.toInt()%2==0 }.sumBy { it.toString().toInt() }
 */