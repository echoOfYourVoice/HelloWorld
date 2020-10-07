package CodeWars.kata7val.dryingPotatoes

import kotlin.math.floor

fun main() {
println(potatoes(99, 100, 98))
}

fun potatoes(p0:Int, w0:Int, p1:Int):Int {
    return floor((w0 * (100 - p0) / (100 - p1)).toDouble()).toInt()
}