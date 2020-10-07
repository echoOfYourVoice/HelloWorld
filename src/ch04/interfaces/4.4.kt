package ch04.interfaces


import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.File

/*
Объявление объекта начинается с ключевого слова object и фактически определяет класс с переменной этого класса в одном выражении.
Объекты объявляются в единственном выражении, тк второй такой объект не нужен(например компаратор сравнения файлов)
 */

// Шаблон одиночка
object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees) {

        }
    }
}

object CaseInsensitiveFileComparator: Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

fun main () {
    Payroll.allEmployees.add(Person("Roman"))
    Payroll.calculateSalary()

    println(CaseInsensitiveFileComparator.compare(File("/User/123.txt"), File("/user")))

    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
    /*
    Объекты-одиночки и внедрение зависимостей
    Как и шаблон <<Одиночка>>, объявления объектов не всегда пригодны для использования
    в больших программных системах. Они прекрасно подходят для небольших модулей с
    малым количеством зависимостей или вообще без них, но не для крупных компонентов,
    взаимодействующих с другими частями системы. Основная причина - в отсутствии контроля над созданием объектов и невозможности управлять параметрами конструкторов.
    Это означает, что в модульных тестах или в разных конфигурациях системы нет возможности заменить реализацию объекта или других классов, зависящих от него. Если
    вам нужна такая функциональность, наряду с обычными классами Kottin вы должны
    использовать библиотеку для внедрения зависимостей (например, Guice, https://github.com/google/guice), как в Java.

     */

val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))

    A.bar()

    val subscribingUser = User2.newSubscribingUser("bob@gmail.com")
    val facebookUser = User2.newFacebookUser(10001)
    println(subscribingUser.nickname)

    /*
    Фабричные методы очень полезны. Как показано в примере, им можно
давать говорящие имена. Кроме того, фабричный метод может возвращать
подклассы того класса, в котором объявлен метод (как в данном примере,
где SubscribingUser и FacebookUser - классы). Также можно запретить
создание новых объектов, когда это нужно. Например, можно проверять
соответствие адреса электронной почты уникальному экземпляру User и " " возвращать существующии экземпляр, а не создавать новыи, если адрес
электронной почты уже присутствует в кэше. Но если такие классы понадобится расширять, то использование нескольких конструкторов может
оказаться лучшим решением, поскольку объекты-компаньоны не могут
переопределяться в подклассах.
     */

    var person = Person.fromJSON("{name: 'Dmitry'}")
    println(person.name)

    val p = Person2.fromJSON("{name: Roma}")
}

data class Person(val name: String) {
    object NameComparator: Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
            p1.name.compareTo(p2.name)
    }
    companion object Loader {
        fun fromJSON(jsonText: String): Person = Person(name = "Имя пользователя")
    }
}

/*
Один из объектов в классе можно отметить специальным ключевым
словом: companion. Сделав это, вы сможете обращаться к методам и свойствам такого объекта непосредственно через имя содержащего его класса,
без явного указания имени объекта. В итоге синтаксис выглядит почти так
же, как вызов статического метода в Java.
 */

class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

    /*
    val nickname: String

    Объявим объект компаньон

    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int) {
        nickname = getFacebookName(facebookAccountId)
    }

     */

    class User2 private constructor(val nickname: String) {
        companion object {
            fun newSubscribingUser(email: String) = User2(email.substringBefore('@'))

            fun newFacebookUser(accountID: Int) = User2(getFacebookName(accountID))

            private fun getFacebookName(accountID: Int) : String {
                when (accountID) {
                    10001 -> return "Roman Klyavlin"
                }
                return "Unknown user"
            }

        }
    }

class JavaCode {
    fun toJSON(collection: Collection<Int?>): String {
        val sb = StringBuilder()
        sb.append("[")
        val iterator = collection.iterator()
        while (iterator.hasNext()) {
            val element = iterator.next()
            sb.append(element)
            if (iterator.hasNext()) {
                sb.append(", ")
            }
        }
        sb.append("]")
        return sb.toString()
    }
}

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class Person1 {
    companion object: JSONFactory<Person> {
        override fun fromJSON(jsonText: String): Person = Person(jsonText.substringBefore('1'))
    }
    /*
    fun loadFromJSON<T>(factory: JSONFactory<T>): T {

    }
     */
}

class Person2 {
    companion object {

    }

}

fun Person2.Companion.fromJSON(json: String): Person {
    return Person("")
}

/*
Ключевое слово object можно использовать не только для объявления
именованных объектов-одиночек, но и для создания анонимных объектов.
Анонимные объекты заменяют анонимные внутренние классы в J ava
 */

/*
window.addMouseListener(
object: MouseAdapter() {
    override fun mouseClicked(e: MouseEvent?) {
        //
    }

    override fun mouseEntered(e: MouseEvent?) {
        //
    }
}
)
Синтаксис ничем не отличается от объявления объекта, за исключением
указания его имени (здесь оно отсутствует). Объект-выражение объявляет класс и создает экземпляр этого класса, но не присваивает имени ни
классу, ни экземпляру. Как правило, в этом нет необходимости, поскольку
объект используется в качестве параметра вызова функции. Если объекту
потребуется дать имя, его можно сохранить в переменной:
 */
val listener = object : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent) {}
    override fun mouseEntered(e: MouseEvent?) {}
}
/*
 В отличие от объявления объекта, анонимные объекты - не <<одиночки>>. При
каждом выполнении объекта-выражения создается новый экземпляр объекта.
 */

fun countClicks(window : Window) {
    var clickCount = 0

    window.addMouseListener(object: MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
         clickCount++
        }
    })
}

/*
 Объекты-выражения полезны, когда в анонимном объекте нужно переопределить несколько методов. Если же требуется реализовать только один метод интерфейса
(такого как Runnable), то можно рассчитывать на поддержку в Kottin преобразований для
интерфейсов с одним абстрактным методом (SAM conversion) - преобразование литерала
функции в реализацию интерфейса с одним абстрактным методом - и написать свою реализацию в виде литерала функции (лямбда-выражения)
 */