package ch05.lambda

import java.awt.Button
import java.net.CacheResponse

fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.maxByOrNull { it.age })
    /*
    Код в фигурных скобках - { it.age } - это лямбда-выражение, реализующее требуемую
логику. В качестве аргумента оно получает элемент коллекции (доступный
по ссылке it) и возвращает значение для сравнения. В данном примере
элемент коллекции - это объект Person, а значение для сравнения - возраст, хранящиися в своистве age.
Если лямбда-выражение делегирует свою работу функции или свойству, u его можно заменить ссылкои на метод.

     */
    people.maxByOrNull(Person::age)
    /*
    Лямбда-выражения в Kotlin всегда окружены фигурными скобками.
    Обратите внимание на отсутствие круглых скобок вокруг аргументов. Список аргументов отделяется от тела лямбда-выражения стрелкои.

    Лямбда-выражение можно сохранить в переменной, а затем обращаться
    к ней как к обычной функции (вызывая с соответствующими аргументами):
     */
    val sum = {x: Int, y: Int -> x + y}
    println(sum(1, 2))
    /*
    При желании лямбда-выражение можно вызывать напрямую:

    Если нужно заключить фрагмент кода в блок, используйте библиотечную
    функцию run, которая выполнит переданное ей лямбда-выражение:
    */
    run { println(42)}

    /*
     Синтаксис языка Kotlin позволяет вынести лямбда-выражение за круглые скобки,
    если оно является последним аргументом вызываемой функции. В этом
    примере лямбда-выражение - единственный аргумент, поэтому его можно поместить после круглых скобок:
     */
    people.maxByOrNull() {p: Person -> p.age}
    /*
    Когда лямбда-выражение является единственным аргументом функции, также можно избавиться от пустых круглых скобок:
     */
    people.maxByOrNull {p: Person -> p.age}

    val names = people.joinToString(separator = " ", transform = {p: Person -> p.name})
    println(names)
    /*
    А вот как можно переписать этот вызов, поместив лямбда-выражение
    за скобками.
     */
    people.joinToString(" ") {p: Person -> p.name}
    /*
    Ещё упростим синтаксис, избавившись от типа параметра.
     */
    people.maxByOrNull { p: Person -> p.age }
    people.maxByOrNull { p -> p.age }
    /*
    Если лямбда-выражение хранится в переменной, то компилятор не
    имеет контекста, из которого можно вывести тип параметра. Поэтому его
    следует указать явно
     */

    val sum1 = {x: Int, y: Int ->
        println("Computing the sum pf $x and $y....")
        x + y
    }
    println(sum1(1, 2))

    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessageWithPrefix(errors, "Error:")

    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal server error")
    printProblemCounts(responses)

    /*
    Но что, если код, который нужно передать, уже определен как функция? Конечно, можно передать лямбда-выражение, вызывающее эту функцию, но это избыточное решение. Можно ли передать функцию напрямую?
    В Kotlin, как и в Java 8, это можно сделать, преобразовав функцию в значение с помощью оператора ::
     */
    val getAge1 = Person::age
    /*
    Это выражение называется ссылкой на член
    класса (rnember reference) и обеспечивает короткий синтаксис создания значения функции, вызывающего ровно один метод или обращающегося к свойству.
    Двойное двоеточие отделяет имя класса от имени члена класса, на которыи нужно сослаться (метод или свойство) Это более краткая форма записи следующего лямбда-выражения:
    val getAge1 = { person: Person -> person.age }
     */

    fun salute() = println("Salute!")
    run(::salute)

    fun sendMail(person: Person, message: String) {
        println("Message with text $message send to ${person.name}")
    }

    val action = {person: Person, message: String -> sendMail(person, message)}
    // это можно переписать ->
    val nextAction = ::sendMail

    val createPerson = ::Person1
    val p = createPerson("Alice", 29)
    println(p)
    val predicate = Person1::isAdult
    /*
    Хотя функция isAdult не является членом класса Person, её можно вызывать через ссылку, точно как при обращении через метод экземпляра:
    person . isAdult.
     */
    println(predicate(p))

    val p1 = Person1("Dmitry", 34)
    val dmitrysAgeFunction = p1::age
    println(dmitrysAgeFunction())


}

/*
Реализация обработчика событий с помощью лямбда-выражения
button.setOnClickListener
 */

data class Person(val name: String, val age: Int)

fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4")) clientErrors++
        else if (it.startsWith("5")) serverErrors++
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

/*
Обратите внимание, что по умолчанию время жизни локальной переменной ограничено временем жизни функции, в которой она объявлена.
Но если она захвачена лямбда-выражением, использующий её код может
быть сохранен и выполнен позже. Вы можете спросить: как это работает? Когда захватывается финальная переменная, её значение сохраняется
вместе с использующим её кодом лямбда-выражения. Значения обычных
переменных заключаются в специальную обертку, которая позволяет менять переменную, а ссылка на обертку сохраняется вместе с лямбда-выражением.
Важно отметить, что если лямбда-выражение используется в качестве
обработчика событий или просто выполняется асинхронно, модификация
локальных переменных произойдет только при выполнении лямбда-выражения. Например, следующий код демонстрирует неправильный способ подсчета нажатии кнопки:
 */

/*
fun tryCountButtonClicks(button: Button): Int {
    var clicks = 0
    button.onClick { clicks++}
    return clicks
}
 */

/*
Вы можете сохранить или отложить операцию создания экземпляра
класса с помощью ссылки на конструктор. Чтобы сформировать ссылку на
конструктор, нужно указать имя класса после двойного двоеточия:
 */

data class Person1(val name: String, val age: Int)

fun Person1.isAdult() = age >= 21
