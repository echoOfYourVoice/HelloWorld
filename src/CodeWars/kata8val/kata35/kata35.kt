package CodeWars.kata8val.kata35

fun main() {
    println(loveFun(1, 4))
    println(loveFun(2, 2))
    println(loveFun(0, 1))
    println(loveFun(0, 0))
}

fun loveFun(flowerA: Int, flowerB: Int) = flowerA % 2 + flowerB % 2 == 1