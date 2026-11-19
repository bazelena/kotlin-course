package com.lessons.lesson21.homeworks

/*
Задача 1
Напишите функцию analyzeDataType, принимающую параметр типа Any.
Функция должна определить тип аргумента и вывести соответствующее сообщение:

    - Для строки: "Это строка: [значение]".
    - Для любого числа: "Это число: [значение]".
    - Для списка: "Это список, количество элементов: [количество]".
    - Для словаря: "Это словарь, количество пар: [количество]".
    - Для остальных типов: "Неизвестный тип данных".

Используйте оператор is для проверки типов.
*/

// вариант ИИ
fun analyzeDataType1(value: Any) {
    when {
        value is String -> println("Это строка: $value")
        value is Number -> println("Это число: $value")
        value is List<*> -> println("Это список, количество элементов: ${value.size}")
        value is Map<*, *> -> println("Это словарь, количество пар: ${value.size}")
        else -> println("Неизвестный тип данных")
    }
}

/*
Задача 2
Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка,
если аргумент можно безопасно привести к типу List. В случае неудачного приведения функция должна возвращать -1.
Используйте as? для безопасного приведения типа.
 */
fun safeCastToList(value: Any): Int {
    val list = value as? List<*>
    return list?.size ?: -1
}

/*
Задача 3
Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки,
если аргумент можно привести к типу String. В случае, если аргумент равен null или не является строкой, функция должна возвращать 0.
 */
fun getStringLengthOrZero(value: Any?): Int {
    val string = value as? String
    return string?.length ?: 0
}

/*
Задача 4
Создайте функцию-расширение класса Any toSquare. Функция гарантированно вызывается у числа (в виде числа или строки, например 4 или 4.2 или “4.2”)
и должна вернуть квадрат этого числа. Если придёт число, его нужно возвести в квадрат, если придёт строка, то его нужно преобразовать
в число через функцию toDouble() и возвести в квадрат.
 */
fun Any.toSquare(): Double {
    return when {
        this is Number -> toDouble() * this.toDouble()
        this is String -> toDouble() * this.toDouble()
        else -> 0.0
    }
}

/*
Задача 5
Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму
всех целочисленных (Int) и вещественных (Double) значений в списке. Все остальные типы должны быть проигнорированы.
 */
fun sumIntOrDoubleValues(value: List<Any>): Double {
    var sum = 0.0
    for (element in value) {
        when {
            element is Int -> sum += element.toDouble()
            element is Double -> sum += element
            else -> {}
        }
    }
    return sum
}

/*
Задача 6
Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к типу List<*>.
Если приведение успешно, функция должна напечатать все строки из списка, если элемент не является строкой,
то вывести предупреждение об этом. Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение программы.
 */
fun tryCastToListAndPrint(element: Any) {
    val list = element as? List<*>
    if (list != null) {
        for (item in list) {
            if (item is String) {
                println(item)
            }
            else {
                println("элемент не является строкой")
            }
        }
    }
    else {
        println("Ошибка: объект не является списком")
    }
}


fun main() {
    analyzeDataType1("Привет")
    analyzeDataType1(25)
    analyzeDataType1(listOf(1, 2, 3))
    analyzeDataType1(mapOf("Анна" to 25))

    safeCastToList(listOf(1, 2, 3))
    safeCastToList(listOf("Муся", "Мурзик"))
    safeCastToList("Мур")
    safeCastToList(100)

    val numbers = listOf(10, 2.5, "Привет", 7, true, 3.5)
    println(sumIntOrDoubleValues(numbers))

    tryCastToListAndPrint(listOf("Kotlin", 123, true))
}