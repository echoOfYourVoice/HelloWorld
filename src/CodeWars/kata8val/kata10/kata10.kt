package CodeWars.kata8val.kata10

fun main() {
println(points(listOf("1:0", "2:0", "3:0", "4:0", "2:1", "3:1", "4:1", "3:2", "4:2", "4:3")))
}

fun points(games: List<String>): Int {
    var result = 0;
    for (c in games) {
    if (c[0] > c[2]) result += 3
        else if (c[0] == c[2]) result += 1
 }
     return result
}

/*
fun points(games: List<String>) =
        games.sumBy {
            val (x, y) = it.split(":")
            when {
                x > y -> 3
                x < y -> 0
                else -> 1
            }
        }
 */