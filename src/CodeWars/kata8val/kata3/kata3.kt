package CodeWars.kata8val.kata3

import kotlin.math.round

fun main() {
    litres(2.0)
}

fun litres(time: Double): Int {
    return(time * 0.5).toInt()
}

/*
fun litres(time: Double) = Math.floor(time/2).toInt()
 */