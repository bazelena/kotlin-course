package com.lessons.lesson11.homeworks

/* Задачи на сигнатуру метода

Напишите сигнатуру метода в которую входит модификатор доступа, название функции, список аргументов
с типами и возвращаемое значение. В теле метода можешь сделать возврат объекта нужного типа если
это требуется для устранения ошибок.
*/

// 1. Не принимает аргументов и не возвращает значения.
fun example1() {
}

// 2. Принимает два целых числа и возвращает их сумму.
fun example2(a: Int, b: Int): Int {
    return a + b
}

// 3. Принимает строку и ничего не возвращает.
fun example3(string: String) {
}

// 4. Принимает список целых чисел и возвращает среднее значение типа Double.
fun example4(numbers: List<Int>): Double {
    return numbers.sum().toDouble() / numbers.size
}

// 5. Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun example5(string: String?): Int? {
    return string?.length
}

// 6. Не принимает аргументов и возвращает nullable вещественное число.
fun example6(): Double? {
    return null
}

// 7. Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun example7(list: List<Int>?) {

}

// 8. Принимает целое число и возвращает nullable строку.
fun example8(number: Int): String? {
    return null
}

// 9. Не принимает аргументов и возвращает список nullable строк.
fun example9(): List<String?> {
    return emptyList()
}
// 10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun example10(arg1: String?, arg2: Int?): Boolean? {
    return true
}


//Задачи на написание кода

//Напишите валидную сигнатуру метода, а так же рабочий код для задач.

// 1. Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(int: Int): Int {
    return int * 2
}

// 2. Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
fun isEven(int: Int): Boolean {
    if (int % 2 == 0) return true
    return false
}

// 3. Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
// Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(n: Int) {
    if (n < 1) return
    for (i in 1..n) {
        println(i)
    }
}

// 4. Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке.
// Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(list: List<Int>): Int? {
    for (number in list) {
        if (number < 0) return number
    }
    return null
}

// 5. Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку.
// Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
fun processList(list: List<String?>) {
    for (item in list) {
        if (item == null) return
        println(item)
    }
}