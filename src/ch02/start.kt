package ch02

import ch02.colors.Color
import ch02.colors.Color.*
import ch02.interfaces.Expr
import ch02.interfaces.Expr.*
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.util.Random;

fun main(args: Array<String>) {
    val question = "The Ul timate Question of Lifе, the Universe , and Everything";
    val answer = 42;
    println("Hello World!");
    println(max(1, 2));
    val person1 = Person("Roman", false);
    println("${person1.name} is married: ${person1.isMarried}");
    val rect1 = Rectangle(10, 5);
    println("${rect1} is square: ${rect1.isSquare}");
    val rect2 = createRandomRectangle();
    println("${rect2} is square: ${rect2.isSquare}");
    println(BLUE.rgb());
    println(getMnemonic(BLUE));
    println(getWarmth(GREEN))
    println(mix(BLUE, YELLOW));
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println("evalWithLogging-----------------------------")
    println(evalWithLogging( Sum(Sum(Num(1) , Num( 2 )), Num(4))))
}

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression");
}

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown error")
    }

fun getMnemonic(color: Color) =
    when (color) {
        RED -> "Каждый"
        ORANGE -> "Охотник"
        YELLOW -> "Желает"
        GREEN -> "Знать"
        BLUE -> "Где"
        INDIGO -> "Сидит"
        VIOLET -> "Фазан"
    }

fun mix(c1: Color, c2: Color) =
    when  (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Грязный цвет")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) ||
                (c1 == YELLOW && c2 == RED) ->
            ORANGE
        (c1 == YELLOW && c2 == BLUE) ||
                (c1 == BLUE && c2 == YELLOW) ->
            GREEN
        (c1 == VIOLET && c2 == BLUE ) ||
                (c1 == BLUE && c2 == VIOLET) ->
            INDIGO
        else -> throw Exception("Dirty color");
    }


fun getWarmth(color: Color) = when(color) {
    RED, ORANGE, YELLOW -> "теплый"
    GREEN -> "нейтральный"
    BLUE, INDIGO, VIOLET -> "холодный"
}

fun max(a: Int , b: Int): Int {
    return if (a > b) a else b;
}

class Person(val name: String, var isMarried: Boolean = false)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
    get() {
        return height == width;
    }
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}