package CodeWars.kata8val.kata26

fun main() {
    println(countPositivesSumNegatives(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15)))
    println(countPositivesSumNegatives(arrayOf()))
}

fun countPositivesSumNegatives(input : Array<Int>?) : Array<Int> {
    var counPositive = 0;
    var sumNegatives = 0;
    if (input != null && input.size != 0) {
        for (i in 0..input.size - 1) when {
            input[i] > 0 -> counPositive++
            else -> sumNegatives += input[i]
        }
        return arrayOf(counPositive, sumNegatives)
    }
    else return arrayOf()
}

//Жесть он крут
/*
fun countPositivesSumNegatives(input : Array<Int>?) : Array<Int> {
    if (input == null || input.isEmpty()) return emptyArray()
    val (positive, negative) = input.partition { it > 0 }
    return arrayOf(positive.count(), negative.sum())
}
 */