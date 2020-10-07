package CodeWars.kata8val.kata2

fun main() {
println(repeatstr(6, "I"))
}

fun repeatstr(count: Int, str: String): String {
    var result: String = "";
    while (result.length + 1 <= count) {
        result += str
    }
    return result;
}

/*
fun repeatStr(r: Int, str: String) = str.repeat(r)
 */