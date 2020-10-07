package ch03.colletions
/*
ключевое слово vararg позволяет объявить функцию, принимающую произвольное количество аргументов;
инфиксная нотация поможет упростить вызовы функций с одним аргументом;
мультидекларации (destructuring declarations) позволяют распаковать одно составное значение в несколько переменных.
 */

fun main() {
    /*
    val list = listOf("args: ", *args)
    println(list)
    Синтаксис вызова функций в Kotlin и Java также отличается способом
    передачи аргументов, уже упакованных в массив. В Java массив передается
    непосредственно, а Kotlin требует явно распаковать массив, чтобы каждый
    элемент стал отдельным аргументом вызываемой функции. Эта операция
    называется вызовом с оператором распаковки (spread operator), а на практике это просто символ * перед соответствующим аргументом:
     */

    val arr = arrayOf(1, 2, 3, 4, 5, 6)
    val list = listOf("args:", *arr)
    println(list)

    // to - инфиксный метод
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    println(map)

    /*
    Ниже представлена упрощенная версия объявления функции to:
    infix fun Any . to(other : Any) = Pair(this , other)
     */
    val (number, element) = 1 to "one"

    infix fun Any.to(other: Any) = Pair(this, other)

    /*
    Это называется мультидекларацией ( destructuring declaration).
    Мультидекларации работают не только с парами. Например, содержимым элемента словаря
    можно инициализировать две переменные, key
    и value.

     */

    // Регулярные выражения
    println("12.345-6.A".split(".", "-"))

    parsePath("/Users/yole/kotlin-book/chapter.adoc")

    parsePathReg("/Users/yole/kotlin-book/chapter.adoc")

}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extention = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extention")

    val kotlinLogo = """| //
                       .|//
                       .|/ \\""".trimMargin(".")
    println(kotlinLogo)

    val price = """${'$'}99.99"""
    println(price)
}

fun parsePathReg(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
    /*
    Это регулярное выражение разбивает путь на три группы, разделенные
    символом слеша и точкой. Шаблон . соответствует любому символу, начиная с начала строки, поэтому первои группе (.+) соответствует подстрока до последнего слеша.
    Эта подстрока включает все предыдущие слеши, потому что они соответствуют шаблону <<любой символ>>. Соответственно, второй группе соответствует подстрока до последнеи точки, а третьей -
    оставшаяся часть.
     */
}