package ch04.interfaces

import javax.naming.Context
import javax.swing.text.AttributeSet


open class View1 {
    constructor(ctx: Context) {

    }
    constructor(ctx: Context, attr: AttributeSet) {

    }
}

class MyButton: View1 {
    constructor(ctx: Context) : super(ctx) {
        //
    }
    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {

    }
}

/*
Классы, реализующие интерфейс User, должны предоставить способ получить значение свойства nickname. Интерфейс не определяет, как будет
доступно значение - как поле или через метод доступа. Поскольку сам интерфейс не имеет состояния, то только реализующие его классы смогут
хранить соответствующее значение
 */

interface User {
    val nickname: String
    /*
    val email: String
    get() = email.substringBefore('@')
     */
}

class PrivateUser(override val nickname: String): User

class SubscribingUser(val email: String) :User {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(val accountID: Int) : User {
    override val nickname = getFacebookName(accountID)

    private fun getFacebookName(accountID: Int): String {
        when (accountID) {
            1001 -> return "Roman Klyavlin"
        }
        return "Unknown user"
    }
}

fun main() {
    println(PrivateUser("test@kotlinlan.org").nickname)
    println(SubscribingUser("test@kotlinlan.org").nickname)
}