package ch02.exceptions

import java.io.BufferedReader
import java.io.StringReader

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun main () {
    /*
    val percetage = 250
if (percetage !in 0..100) {
    throw IllegalArgumentException(
        "A percetage must be between 0 and 100: $percetage"
    )
}

     */
    val reader = BufferedReader(StringReader("not a number"))
    readNumber(reader)
}

fun readNumber(reader: BufferedReader) {
    /*
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }
    catch (e: NumberFormatException) {
        return null
    }
    finally {
        reader.close()
    }

     */
    val number = try {
        Integer.parseInt(reader.readLine())
    }
    catch (e: NumberFormatException) {
        return
    }
    println(number)
}

