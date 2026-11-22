package com.lessons.lesson22.homeworks

/*
Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий IndexOutOfBoundsException тип
в качестве аргумента. Напиши код, который спровоцирует выброс IndexOutOfBoundsException, перехвати его с помощью try-catch
и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.
 */

class MyRuntimeException(cause: IndexOutOfBoundsException) : RuntimeException(cause)

fun main() {
    try {
        listOf("a, b, c")[2]
    } catch (e: IndexOutOfBoundsException) {
        println("Пойман IndexOutOfBoundsException")
        throw MyRuntimeException(e)
    }
}

