package CodeWars.kata8val.kata32

fun main() {
println(reverseWords("I like eating"))
}

fun reverseWords(str:String): String {
    var result = ""
val reversedStr = str.split(" ").reversed()
    for (i in 0..reversedStr.size - 1) {
       result += reversedStr[i]
        if (i < reversedStr.size - 1) result += " "
    }
    return result
}
/*
object Reverse {
  fun reverseWords(str: String): String = str.split(' ').reversed().joinToString(" ")
}
 */