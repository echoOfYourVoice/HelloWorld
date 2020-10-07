package ch02.interfaces

import java.lang.IllegalArgumentException

 interface Expr {
    class Num(val value: Int): Expr
    class Sum (val left: Expr, val right: Expr) : Expr

    fun eval(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.right) + eval(e.left)
            else -> throw IllegalArgumentException("Unknown expression")
        }
}

sealed class ExprClass {
    class Num(val value: Int): ExprClass()
    class Sum(val left : ExprClass , val right : ExprClass) : ExprClass()
}

fun evalClass(e: ExprClass): Int =
    when (e) {
        is ExprClass.Num -> e.value
        is ExprClass.Sum -> evalClass(e.right) + evalClass(e.left)
    }

class User constructor(_nickname: String) {
    val nickname: String

    // init - начало блока инициализации
    init {
        nickname = _nickname
    }
}

/*
Если класс имеет суперкласс, основной конструктор также должен инициализировать свойства, унаследованные от суперкласса. Сделать это
можно, перечислив параметры конструктора суперкласса после имени его
типа в списке базовых классов :
 */

open class User1(val nickname: String) {}
class TwitterUser(nickname: String) : User1(nickname) {}

open class Button

class RadioButton: Button()

class Secretive private constructor() {}

/*
В большинстве сценариев конструктор класса выглядит очень просто: он
либо не имеет параметров, либо присваивает их значения соответствующим свойствам. Вот почему в языке Kotlin такой лаконичный синтаксис
определения основных конструкторов: он отлично подходит для большинства случаев. Но в жизни всё бывает сложнее, поэтому Kotlin позволяет
определить столько конструкторов, сколько потребуется.
 */

fun main() {
    evalClass(ExprClass.Sum(ExprClass.Num(1), ExprClass.Num(3)))
}
