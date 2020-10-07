package ch04.interfaces

import java.io.Serializable

/*
Видимость:
public(по умолчанию) - член класса доступен повсюду - объявление верхнего уровня доступен повсюду
internal - член класса доступен только в модуле - объявление верхнего уровня доступен в модуле
protected - член класса доступен в подклассах - ----------------
private - член класса доступен в классе -  объявление верхнего уровня доступно в файле
 */

internal class TalkativeButton : Focusable {
    private fun yell() = println("Hey")
    protected fun whisper() = println("Let's talks")
}

/*
Ошибка - "публичный член класса раскрывает внутренний тип-приемник" TalkativeButton
fun TalkativeButton.giveSpeech() {
Функция yell() недоступна, она объявлена как private
    yell()
 Функция yell() недоступна, она объявлена как protected
    whisper()
}
 */

// Объявление видимого элемента с сериализуемым состоянием
interface State: Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class ButtonState : View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {/*......*/}
    /*
    В Kotlin вложенный класс без модификаторов это полный аналог статического вложенного класса в Java. Чтобы превратить его во внутренний
    класс со ссылкой на внешний класс, нужно добавить модификатор inner
     */
   class ButtonState(): State {/*........*/}
}

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}