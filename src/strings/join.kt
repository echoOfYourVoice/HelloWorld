package strings
import java.lang.StringBuilder

var opCount = 0
const val UNIX_LINE_SEPARATOR = "\n"

fun <T> joinToStringWithParam(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    performOperation()
    return result.toString()
}

fun <T> Collection<T>.joinToString(
    separator: String,
    prefix: String,
    postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    performOperation()
    return result.toString()
}

// Функция расширение
// String - тип-получатель
// экземпляр данного типа - объект получатель
// можно обращаться без this
val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
get() = get(length - 1)
set(value: Char) {
    this.setCharAt(length - 1, value)
}

fun performOperation() {
    opCount++
    println("Operation performed $opCount times")
}
