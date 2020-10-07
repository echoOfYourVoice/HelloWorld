package CodeWars.kata8val.kata27

import kotlin.math.abs

fun main() {
println(elevator(0,1,0))
println(elevator(0,1,1))
println(elevator(0,1,2))
println(elevator(0,0,0))
println(elevator(0,2,1))
}

fun elevator(left: Int, right: Int, call: Int): String {
    val i1 = if (call - left < 0) (call - left) * -1 else call - left
    val i2 = if (call - right < 0) (call - right) * -1 else call - right
    when {
        i1 < i2 -> return "left"
        i1 > i2 -> return "right"
        else -> return "right"
    }
}

// Жесть он крут
/*
import kotlin.math.abs
fun elevator(left: Int, right: Int, call: Int) = if (abs(call - left) < abs(call - right)) "left" else "right"
 */