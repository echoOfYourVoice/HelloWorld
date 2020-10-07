package CodeWars.kata7val.fixStringCase

fun main() {

}

fun solve(s: String): String {
    var count = 0
    for (c in s) if (c in 'A'..'Z') count++
    return if (count > s.length / 2) s.toUpperCase() else s.toLowerCase()
}

/*
fun solve(s: String): String = if (s.count { it.isLowerCase() } >= s.length/2.0) s.toLowerCase() else s.toUpperCase()
 */