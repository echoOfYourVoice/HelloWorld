package CodeWars.kata7val.overTheRoad

/*
import java.util.TreeMap

 */

fun main() {

println(overTheRoad(1,3))
println(overTheRoad(3,3))

println(overTheRoad(2,3))
println(overTheRoad(3,5))
println(overTheRoad(7,11))
println(overTheRoad(20,1000000))
}

fun overTheRoad(address: Int, n: Int): Int? {
    //Работает, но не входит во время выполнения
    //Я не ищу легких путей))))) нарисовав на бумаге вышло намного проще
/*
    val map = TreeMap<Int, Int>()
    var count = if (address % 2 == 0) 2 else 1
    for (i in n downTo 1 step 2) {
        map[count] = i * 2 - if (address % 2 == 0) 1 else 0
        if (count == address) break
        count += 2
    }
    return map[address]?.toInt()
 */
    return n * 2 - (address - 1)
}