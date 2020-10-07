package CodeWars.kata8val.kata34

import kotlin.math.abs

fun main() {
println(twiceAsOld(36,7))
println(twiceAsOld(55,30))
println(twiceAsOld(42,21))
println(twiceAsOld(22,1))
println(twiceAsOld(29,0))
}

fun twiceAsOld(dadYearsOld: Int, sonYearsOld: Int) = abs(sonYearsOld * 2 - dadYearsOld)