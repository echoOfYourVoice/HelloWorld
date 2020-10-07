package stepik.UnixEra.calculateBugMentions
import java.lang.Exception
import java.util.*
import kotlin.math.abs


fun main() {
val c1 = NibirunianClass()

    val storage = SugarStorage(5)
    println(storage.decreaseSugar(-5))

    val s1 = "PDDPEM MXWHL XJID XJID XJID DTQEHGC DTQEHGC MXWHL XJID DTQEHGC DTQEHGC MXWHL PDDPEM QUCO DTQEHGC MXWHL DTQEHGC MXWHL PDDPEM XJID MXWHL DTQEHGC DTQEHGC XJID XJID XJID MXWHL MXWHL MXWHL MXWHL DTQEHGC PDDPEM DTQEHGC DTQEHGC PDDPEM"
    println(calculateWordStat(s1))
}

fun calculateBugMentions(input: List<String>): Int {
return input.count { it == "BUG" }
}

class NibirunianClass(var namePlate: String = "") {

    fun createNamePlate(name: String) {
        namePlate = "Live long and prosper, $name"
    }
}

class SugarStorage(var volume: Int) {

    fun increaseSugar(v:Int) {
        volume += abs(v)
    }
    fun decreaseSugar(v:Int) {
        if (v < 0) return
        volume = if (volume - v < 0) 0 else volume - v
    }
}

open class Bug(val rank: Int, val name:String) {
    open fun getSugarLimit(): Int{
        return rank
    }

    fun getId(): String{
        return "${rank}.${name}"
    }
}

class  BugCivilian(rank: Int, name: String): Bug(rank, name) {
    override fun getSugarLimit(): Int {
        return super.getSugarLimit() / 2
    }
}

fun getCubeList(n:Int): List<Int>{
    return List(n - 1) { index -> index * index * index }
}



//Возврат самого повторяющегося элемента
fun calculateWordStat(input:String): String? {
 return input.split(" ").groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
}

fun exceptionExample(): Nothing = throw Exception()


class DogException() : Exception()
class CatException() : Exception()
fun checkClient(client: String) {
    if (client.contains("dog"))  throw DogException()
    else if (client.contains("cat")) throw CatException()
}


class EngineNotFoundException : Exception()
class SensorsMeltException : Exception()

fun engineStatus(engineNumber:Int): String{

    return try {
        ""//rawEngineStatus(engineNumber)
    }
    catch (e: EngineNotFoundException) {
        "engine $engineNumber not found"
    }
    catch (e: SensorsMeltException) {
        "engine $engineNumber offline"
    }

}

fun calcNullValues(input: Array<Int?>):Array<Int>{
    return arrayOf(input.count { it == null }, input.filterNotNull().sumBy { it })
}

