package CodeWars.kata8val.kata30

fun main() {

}

fun grow(arr: IntArray): Int {
    var multiply = 1
    for (i in 0.. arr.size - 1) multiply *= arr[i]
    return multiply

}

/*
fun grow(arr: IntArray): Int = arr.reduce { a, b -> a * b }
 */