package com.lessons.lesson09.homeworks

// Работа с массивами Array

fun main() {

// 1. Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val array1: Array<Int> = arrayOf(1, 2, 3, 4, 5)

// 2. Создайте пустой массив строк размером 10 элементов.
    val array2: Array<String> = Array(10) { "" }

// 3. Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
    val array3: DoubleArray = doubleArrayOf(1.1, 2.2, 3.3, 4.4, 5.5)

// 4. Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
    val array4 = Array(5) { 0 }
    for (i in array4.indices) {
        array4[i] = i * 3
    }

// 5. Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val array5: Array<String?> = arrayOf(null, "love", "Kotlin")

// 6. Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val array6 = arrayOf(1, 2, 3, 4, 5)
    val copyArray6 = IntArray(array6.size)
    for (i in array6.indices) {
        copyArray6[i] = array6[i]
    }

// 7. Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого.
// Распечатайте полученные значения.
    val array7 = arrayOf(1, 3, 5, 7, 9)
    val array8 = arrayOf(2, 4, 6, 8, 10)

    val result = IntArray(array7.size)
    for (i in array7.indices) {
        result[i] = array7[i] - array8[i]
    }
    println(result.joinToString())

// 8. Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
    val array9 = arrayOf(3, 7, 5, 2, 9)
    var index = -1
    var i = 0
    while (i < array9.size) {
        if (array9[i] == 5) {
            index = i
            break
        }
        i++
    }
    println(index)

// 9. Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    val array10 = arrayOf(1, 2, 3, 4, 5)
    for (num in array10) {
        if (num % 2 == 0) {
            println("$num - чётное")
        } else {
            println("$num - нечётное")
        }
    }

    // 10. Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент,
//в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
    fun findBySubstring(array: Array<String>, query: String): String? {
        for (item in array) {
            if (item.contains(query)) {
                return item
            }
        }
        return null
    }

    val words = arrayOf("Kotlin", "Java", "Python")
    val found = findBySubstring(words, "tli")
    println(found)


// Работа со списками List

// 1. Создайте пустой неизменяемый список целых чисел.
    val list01: List<Int> = emptyList()

// 2. Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val list02: List<String> = listOf("Hello", "World", "Kotlin")

// 3. Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val list03: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)

// 4. Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    val list04: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    list04.addAll(listOf(6, 7, 8))

    println(list04)

// 5. Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val list05 = mutableListOf("Hello", "World", "Kotlin")
    list05.remove("World")

    println(list05)

// 6. Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    val list06 = listOf(1, 2, 3, 4, 5)
    for (element in list06) {
        println(element)
    }

// 7. Создайте список строк и получите из него второй элемент, используя его индекс.
    val list07 = mutableListOf("a", "b", "c")
    val secondElement = list07[1]
    println(secondElement)

// 8. Имея изменяемый список чисел, измените значение элемента на определенной позиции
// (например, замените элемент с индексом 2 на новое значение).
    val list08 = mutableListOf(100, 200, 300, 400, 500)
    list08[2] = 5000
    println(list08)

// 9. Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков.
// Реши задачу с помощью циклов.
    val firstList: List<String> = listOf("Hello", "World")
    val secondList: List<String> = listOf("I", "love", "QA")

    val resultList = mutableListOf<String>()
    for (item in firstList) {
        resultList.add(item)
    }
    for (item in secondList) {
        resultList.add(item)
    }
    println(resultList)

// 10. Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    val list10 = listOf(4, 8, 1, 9, 3)
    var min = list10[0]
    var max = list10[0]
    for (num in list10) {
        if (num < min) min = num
        if (num > max) max = num
    }
    println("Минимум: $min, Максимум: $max")

// 11. Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
    val list11 = listOf(1, 2, 3, 4, 5, 6)
    val evenList = mutableListOf<Int>()
    for (num in list11) {
        if (num % 2 == 0) {
            evenList.add(num)
        }
    }
    println(evenList)

// Работа с Множествами Set

// 1. Создайте пустое неизменяемое множество целых чисел.
    val set01: Set<Int> = emptySet()

// 2. Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val set02: Set<Int> = setOf(1, 2, 3)

// 3. Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
    val set03: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")

// 4. Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    val set04: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")
    set04.addAll(listOf("Swift", "Go"))
    println(set04)

// 5. Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    val set05: MutableSet<Int> = mutableSetOf(1, 2, 3, 4, 5)
    set05.remove(2)
        println(set05)

// 6. Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    val set06: Set<Int> = setOf(1, 2, 3, 4, 5)
    for (item in set06) {
        println(item)
    }

// 7. Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка.
// Нужно распечатать булево значение true если строка есть. Реши задачу через цикл.

    fun containsString(set: Set<String>, query: String): Boolean {
        for (item in set) {
            if (item == query) {
                return true
            }
        }
        return false
    }

        val set07 = setOf("Kotlin", "Java", "Scala")
        println(containsString(set07, "Java"))


// 8. Создайте неизменяемое множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
    val set08: Set<String> = setOf("Kotlin", "Java", "Scala")
    val myList = mutableListOf<String>()

    for (item in set08) {
        myList.add(item)
    }

    println(myList)
}

