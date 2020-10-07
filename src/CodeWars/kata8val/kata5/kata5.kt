package CodeWars.kata8val.kata5

fun main() {
println(dutyFree(12, 50, 1000))
    println(dutyFree(17, 10, 500))
    println(dutyFree(24, 35, 3000))
    println(dutyFree(377, 40, 9048))
    println(dutyFree(2479, 51, 13390))

}

fun dutyFree(normPrice: Int, discount:Int, hol:Int) : Int {
    return (hol / (discount.toFloat() * normPrice.toFloat() / 100)).toInt()
}


/*
fun dutyFree(normPrice: Int, discount:Int, hol:Int) = hol * 100 / (normPrice * discount)

 */