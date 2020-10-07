package ch04.interfaces

internal class User1(val name: String) {
    var address: String = "unspecified"
    set(value: String) {
        println("""
            Address was changed for $name:
            "$field" -> "$value".""".trimIndent())
        field = value
    }
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main() {
    val user = User1("Alice")
    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
    /*
    lateinit - модификатор перед значением, не может принимать значение null
     Для совместимости с Jаvа-фреймворками можно использовать аннотации, имитирующие особенности Java в языке Kottin. Например, аннотация @JvmField перед
    свойством открывает доступ к полю с модификатором public без методов доступа.
    Модификатор const делает работу с аннотациями удобнее, потому что позволяет " использовать своиство простого типа или типа String в качестве аргумента аннотации.
     */
}

