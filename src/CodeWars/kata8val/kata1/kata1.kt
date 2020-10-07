package CodeWars.kata8val.kata1

fun main() {
 println(area_or_perimetr(6, 10))
    println(area_or_perimetr(4, 4))
}

fun area_or_perimetr(i1: Int,  i2: Int): Int {
    when {
        i1 == i2 -> return i1 * i2
        i1 != i2 -> return i1 * 2 + i2 * 2
    }
    return 0;
}

/*
fun areaOrPerimeter(l: Int, w: Int) = if (l == w) l * w else 2 * (l + w)
 */