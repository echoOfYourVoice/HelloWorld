package ch02.cycles

import java.util.*

fun main() {
    // Диапазон
    val oneToTen = 1..10
    println(oneToTen)
    for (i in 1..100) println(fizzBuzz(i))
    println("-----------------------------------------")
    for (i in 100 downTo 1 step 2) println(fizzBuzz(i))
    println("-----------------------------------------")
    val size = 10
    for (i in 1..size) println(i)
    //TreeMap - словарь
    val binaryReps = TreeMap<Char, String>()

    /*
binaryReps[c] = binary
эквивалентен следующему коду на Java:
binaryReps.put(c , binary)

 */

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    val list = arrayListOf<String>("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    println(isLetter('q'))
    println(isLetter('Я'))

    println(recognize('8'))

    /*
    Обратите внимание, что здесь строки сравниваются по алфавиту, потому что именно так класс String реализует интерфейс Comparable.
     */
    println("Kotlin" in "Java".."Scala")
}
/*
Здесь выполняется обход прогрессии с шагом, что позволяет пропускать
некоторые значения. Шаг также может быть отрицательным - в таком случае обход прогрессии будет выполняться в обратном направлении.
Выражение 100 downTo 1 в данном примере - это убывающая прогрессия (с шагом - 1). Оператор step меняет абсолютное значение шага на 2, не меняя
направления (фактически он устанавливает шаг равным -2).
 */

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun recognize(c: Char) = when (c) {
    in '0'.. '9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."
}
