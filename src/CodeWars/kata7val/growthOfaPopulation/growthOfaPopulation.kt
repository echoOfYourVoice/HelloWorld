package CodeWars.kata7val.growthOfaPopulation

fun main() {
println(nbYear(1500, 5.0, 100, 5000))
}

fun nbYear(pp0:Int, percent:Double, aug:Int, p:Int):Int {
    var years = 0
    var population = pp0.toDouble()
    while (population < p) {
    population += population * percent / 100 + aug
       years++
    }
    return years
}

/*
fun nbYear(pp0: Int, percent: Double, aug: Int, p: Int): Int =
  generateSequence(pp0.toDouble()) { it * (1 + percent / 100) + aug }.takeWhile { it < p }.count()
 */