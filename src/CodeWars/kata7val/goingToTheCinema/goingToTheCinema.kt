package CodeWars.kata7val.goingToTheCinema

import kotlin.math.ceil
import kotlin.math.pow

fun main() {
println(movie(500, 15, 0.9))
println(movie(100, 10, 0.95))
}

fun movie(card:Int, ticket:Int, perc:Double):Int {
    var count = 1
    var systemB = card.toDouble()
    while (true) {
        var systemA = ticket * count
        systemB += ticket * perc.pow(count.toDouble())
        count++
        if (systemA > ceil(systemB)) return count - 1
        }
    }

/*
fun movie(card:Int, ticket:Int, perc:Double):Int {
    var systemA = 0
    var systemB = card.toDouble()
    var prev = ticket.toDouble()
    var times = 0
    while (systemA <= Math.ceil(systemB))
    {
      systemA += ticket
      prev *= perc
      systemB += prev
      times += 1
    }
    return times
}
 */
