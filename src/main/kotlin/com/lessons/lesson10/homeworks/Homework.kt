package com.lessons.lesson010.homeworks

// Задачи на работу со словарём

fun main() {

// 1. Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
    val map1: Map<Int, Int> = mapOf()

// 2. Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
    val map2 = mapOf(23.45f to 1.1, 34.55f to 2.2, 66.95f to 3.3)

// 3. Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
    val map3 = mutableMapOf<Int, String>()

// 4. Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
    val map4 = mutableMapOf("key1" to "value1", "key2" to "value2")
    map4["key3"] = "value3"

    println(map4)

// 5. Используя словарь из предыдущего задания, извлеките значение, используя ключ. Попробуй получить значение с ключом, которого в словаре нет.
    println(map4["key1"])                 // вернёт "value1"
    println(map4["несуществующий ключ"])  // вернёт null, а не ошибку

// 6. Удалите определенный элемент из изменяемого словаря по его ключу.
    val map6 = mutableMapOf("key1" to "value1", "key2" to "value2")
    map6.remove("key2")

    println(map6)

// 7. Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение.
// Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
    val map7: MutableMap<Double, Int> = mutableMapOf(10.55 to 5, 200.2 to 20)
    for ((key, value) in map7) {
        if (value == 0) {
            println("бесконечность")
        } else {
            println(key / value)
        }
    }

// 8. Измените значение для существующего ключа в изменяемом словаре.
    val map8 = mutableMapOf("Яблоко" to "Фрукт", "Малина" to "Ягода")
    map8["Яблоко"] = "Апельсин"

    println(map8)

// 9. Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
    val mapOne = mutableMapOf("Cat" to "Pet")
    val mapTwo = mutableMapOf("Tit" to "Bird")

    val mapResult = mutableMapOf<String, String>()

    for ((key, value) in mapOne) { // Первый цикл перебирает все пары mapOne и добавляет их в mapResult
        mapResult[key] = value
    }
    for ((key, value) in mapTwo) { // Второй цикл делает то же самое для mapTwo
        mapResult[key] = value
    }

    println(mapResult)

// 10. Создайте словарь, где ключами являются строки, а значениями - списки целых чисел. Добавьте несколько элементов в этот словарь.
    val map10 = mutableMapOf("Числа" to mutableListOf(1, 2, 3, 4, 5))
    map10["Ещё числа"] = mutableListOf(100, 200)

    println(map10)

// 11. Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк.
// Добавь данные в словарь. Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку.
// Распечатай полученное множество.
    val map11 = mutableMapOf(
        1 to mutableSetOf("яблоко", "груша"),
        2 to mutableSetOf("кот", "собака")
    )
    val mySet = map11[1]        // получаем множество по ключу 1
    mySet?.add("банан")          // добавляем новую строку в это множество

    println(mySet)

// 12. Создай словарь, где ключами будут пары чисел. Через перебор найди значение у которого пара будет содержать
// цифру 5 в качестве первого или второго значения.

    val map12 = mapOf(
        Pair(1, 2) to "первое значение",
        Pair(5, 3) to "второе значение",
        Pair(7, 5) to "третье значение"
    )

    for ((key, value) in map12) {
        if (key.first == 5 || key.second == 5) {
            println(value)
        }
    }


// Задачи на подбор оптимального типа для словаря

// 1. Словарь библиотека: Ключи - автор книги, значения - список книг
    val library: Map<String, List<String>> = mapOf()

// 2. Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
    val plants: Map<String, List<String>> = mapOf()

// 3. Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
    val quarterFinals: MutableMap<String, MutableList<String>> = mutableMapOf()

// 4. Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
    val course: MutableMap<String, MutableList<String>> = mutableMapOf()

// 5. Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
    val mapTravel: MutableMap<String, MutableMap<String, MutableList<String>>> = mutableMapOf()

}