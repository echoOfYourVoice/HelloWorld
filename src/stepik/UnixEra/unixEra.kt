package stepik.UnixEra

fun main() {

}

fun getYearEra(year: Int): String{
    return when {
        year >= 2100 -> "distant future"
        year in 1971..1999 -> "after (XX century)"
        year in 2000..2099 ->"after (XXI century)"

        else -> "before"
    }
}