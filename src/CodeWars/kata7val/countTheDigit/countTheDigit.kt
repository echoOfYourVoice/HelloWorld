package CodeWars.kata7val.countTheDigit

import kotlin.math.pow

fun main() {
println(nbDig(25, 1))
println(nbDig(5750, 0))
}

fun nbDig(n:Int, d:Int):Int {
    var count = 0
        for (i in 0..n) {
        val strInt = (i * i).toString()
            count += strInt.length - strInt.replace(d.toString(), "").length
        }
    return count
}