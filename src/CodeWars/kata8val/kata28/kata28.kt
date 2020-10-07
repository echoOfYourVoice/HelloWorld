package CodeWars.kata8val.kata28

fun main() {
println(invert(intArrayOf(1,2,3,4,5)))
println(invert(intArrayOf(-1,2,-3,4,-5)))
println(invert(intArrayOf()))
println(invert(intArrayOf(0)))
}

fun invert(arr: IntArray) = arr.map { -it }.toIntArray()