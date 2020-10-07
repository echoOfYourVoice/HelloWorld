package CodeWars.kata8val.kata37

fun main() {
println(calculateYears(1))
println(calculateYears(2))
println(calculateYears(10))
}

fun calculateYears(years: Int): Array<Int> {
  var catYears = 0
    var dogYears = 0
    for (i in 1..years) {
        if (i == 1) {
            catYears += 15
            dogYears += 15
        }
        else if (i == 2) {
            catYears += 9
            dogYears += 9
        }
        else {
            catYears += 4
            dogYears += 5
        }
    }
    return arrayOf(years, catYears, dogYears)
}

/*
package solution
fun calculateYears(years: Int): Array<Int> =
    when (years) {
        1 -> arrayOf(1, 15 , 15)
        2 -> arrayOf(years, 24 , 24)
        else -> arrayOf(years, 24 + 4 * (years - 2), 24 + 5 * (years - 2))
    }
 */