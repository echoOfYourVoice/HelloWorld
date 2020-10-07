package CodeWars.kata8val.kata36

fun main() {
println(replace("Hi!"))
println(replace("!Hi! Hi!"))
println(replace("aeiou"))
println(replace("ABCDE!"))
}

fun replace(s: String) = s.replace("[aeiouAEIOU]".toRegex(), "!")
