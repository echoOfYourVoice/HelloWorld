package ch04.interfaces

data class Client(val name: String, val postalCode: Int) {
    //Вместе с equals всегда должен переопределяться метод hashCode

    /*
    тк есть модификатор data комментирую переопределенные методысвойства, не объявленные в основном конструкторе, не принимают участия в проверках равенства и вычислении хэш-кода

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun toString() = "Clent(name = $name, postalCode=$postalCode"
     */
}

/*
рекомендуется использовать свойства, доступные
только для чтения, чтобы сделать экземпляры класса неизменяемыми. Это необходимо, чтобы экземпляры можно было использовать в качестве ключей в HashMap или аналогичном контейнере -
иначе контейнер может оказаться в некорректном состоянии, если объект, используемый в качестве ключа, изменится после добавления в контейнер.
 */

fun main() {
    val client1 = Client("Alice", 342562)
    println(client1)
    val client2 = Client("Alice", 342562)
    println(client1 == client2)

    client1.hashCode()

    val processed = hashSetOf(Client("Alice", 342562))
    println(processed.contains(Client("Alice", 342562)))

    /*
    Самое замечательное, что в Kotlin вам не придется создавать всех этих
    методов. Добавьте в объявление класса модификатор data - и все необходимые методы появятся автоматически.
     */

    val bob = Client("Bob", 973293)
    println(bob.copy(postalCode = 382555))

    val cset = CoutingSet<Int>()
    cset.addAll(listOf(1, 1, 3))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}

class DelegationColletcion<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList {}

class CoutingSet<T>(
    val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }

    /*
    здесь переопределяются методы add и addAll, которые увеличивают значение счетчика, а реализация остальных методов интерфейса MutableCollection делегируется декорируемому контейнеру.
     */
}