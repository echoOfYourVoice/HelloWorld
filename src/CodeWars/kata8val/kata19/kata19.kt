package CodeWars.kata8val.kata19

fun main() {
println(removeChar("eloquent"))
}

fun removeChar(str: String) = str.removeRange(0, 1).removeRange(str.length - 2, str.length - 1)

/*
fun removeChar(str: String): String = str.substring(1,str.lastIndex)
 */