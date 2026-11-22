package com.lessons.lesson22.homeworks

// Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:

fun main() {

    // 1. NullPointerException
    try {
        null!!
    } catch (e: NullPointerException) {
        println("Пойман NullPointerException")
    }

    // 2. IndexOutOfBoundsException
    try {
        listOf("a", "b")[0]
    } catch (e: IndexOutOfBoundsException) {
        println("Пойман IndexOutOfBoundsException")
    }

    // 3. ClassCastException
    try {
        "текст" as Int
    } catch (e: ClassCastException) {
        println("Пойман ClassCastException")
    }

    // 4. IllegalArgumentException
    try {
        require(false)
    } catch (e: IllegalArgumentException) {
        println("Пойман IllegalArgumentException")
    }

    // 5. NumberFormatException
    try {
        "не число".toInt()
    } catch (e: NumberFormatException) {
        println("Пойман NumberFormatException")
    }

    // 6. IllegalStateException
    try {
        check(false)
    } catch (e: IllegalStateException) {
        println("Пойман IllegalStateException")
    }

    // 7. OutOfMemoryError
    try {
        val bytes = ByteArray(Int.MAX_VALUE)
    } catch (e: OutOfMemoryError) {
        println("Пойман OutOfMemoryError")
    }

    // 8. StackOverflowError
    try {
        recursiveCall()
    } catch (e: StackOverflowError) {
        println("Пойман StackOverflowError")
    }
}

fun recursiveCall(): Nothing = recursiveCall()

// 9. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок.

/*
Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни набор действий
с этим аргументом, которые могут потенциально вызвать одно из исключений в этом же порядке:

1. NullPointerException
2. IndexOutOfBoundsException
3. ClassCastException
4. IllegalArgumentException
5. NumberFormatException
6. IllegalStateException
В блоке catch перехватывай исключение с общим типом Throwable а внутри через when определи тип исключения и выведи сообщение
с названием исключения. Сразу после when выброси перехваченное исключение через throw, чтобы прекратить работу программы.
Если аргумент функции не вызвал исключение, то выведи текст, сообщающий, что переданный аргумент фантастически хорош!
 */



