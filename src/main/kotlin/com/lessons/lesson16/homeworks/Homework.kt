package com.lessons.lesson16.homeworks

import kotlin.math.PI
import kotlin.math.sin

fun main() {
    // 1. Животные
    val animals: List<Animal> = listOf(Dog(), Cat(), Bird())
    for (animal in animals) {
        animal.makeSound()
    }

    // 2. Фигуры
    val shapes: List<Shape> = listOf(Circle(2.0), Square(3.0), Triangle(4.0, 5.0, 30.0))
    for (shape in shapes) {
        println("%.2f".format(shape.area()))
    }

    // 3. Принтеры
    LaserPrinter().printDoc("Лазерный принтер печатает чёрным по белому")
    InkjetPrinter().printDoc("Струйный принтер печатает каждое слово своим цветом и повторяет цвета по кругу если слов больше чем цветов")

    // 4. Корзина
    val cart = Cart()
    cart.addToCart("A100")
    cart.addToCart("B200", 3)
    cart.addToCart(mapOf("A100" to 2, "C300" to 5))
    cart.addToCart(listOf("B200", "D400", "D400"))
    println(cart)

    // 5. Логгер
    val logger = Logger()
    logger.log("Приложение запущено")
    logger.log("WARNING", "Мало места на диске")
    logger.log("ERROR", "Не удалось подключиться к серверу")
    logger.log("DEBUG", "Значение переменной x = 5")
    logger.log(listOf("Шаг 1 выполнен", "Шаг 2 выполнен"))
    logger.log(IllegalStateException("Корзина пуста"))
}

object Colors {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[30m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}
object Background {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[40m"
    const val RED = "\u001B[41m"
    const val GREEN = "\u001B[42m"
    const val YELLOW = "\u001B[43m"
    const val BLUE = "\u001B[44m"
    const val PURPLE = "\u001B[45m"
    const val CYAN = "\u001B[46m"
    const val WHITE = "\u001B[47m"
}

/*
1. Животные и Их Звуки
    1. Базовый класс: Animal с методом makeSound().
    2. Классы наследники: Dog, Cat, Bird.
    3. Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
    4. Переопределите метод makeSound() в каждом классе-наследнике,
       чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet". Обогати вывод звуков цветом.
    5. Создайте список животных List<Animal> и вызовите в цикле метод makeSound()
*/
abstract class Animal {
    open fun makeSound() {
        println("This animal makes no sound.")
    }
}

class Dog : Animal() {
    override fun makeSound() {
        println("${Colors.CYAN}Bark${Colors.RESET}")
    }
}

class Cat : Animal() {
    override fun makeSound() {
        println("${Colors.YELLOW}Meow${Colors.RESET}")
    }
}

class Bird : Animal() {
    override fun makeSound() {
        println("${Colors.PURPLE}Tweet${Colors.RESET}")
    }
}

/*
2. Геометрические Фигуры и Их Площадь
    1. Абстрактный (базовый) класс: Shape с open методом area().
    2. Классы наследники: Circle, Square, Triangle.
    3. Метод area() возвращает 0.0.
    4. Переопределите метод area() в каждом классе-наследнике для расчета площади соответствующей фигуры.
    5. Подсказка: каждый класс должен иметь аргументы конструктора, позволяющие вычислить площадь
       (для круга это радиус, для квадрата это сторона, для треугольника это две стороны и угол между ними)
    6. Создай набор геометрических фигур и выведи в цикле их площадь
*/

abstract class Shape {
    open fun area(): Double {
        return 0.0
    }
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return PI * radius * radius
    }
}

class Square(val side: Double) : Shape() {
    override fun area(): Double {
        return side * side
    }
}

class Triangle(
    val sideA: Double,
    val sideB: Double,
    val angleDegrees: Double
) : Shape() {
    override fun area(): Double {
        return sideA * sideB * sin(Math.toRadians(angleDegrees)) / 2
    }
}

/*
3. Принтер
    1. Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве аргумента строку.
    2. Создай классы наследники: лазерный и струйный
    3. Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно чёрными буквами
       на белом фоне (хорошо работает на тёмной теме)
    4. Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами
       на цветном фоне. Слова должны быть разноцветны. Можно сделать список пар с цветом текста и фона и проходить
       циклически по этому списку при выводе текста. Проверить работу на длинном тексте
*/

abstract class Printer {
    abstract fun printDoc(abstractPrint: String)
}

class LaserPrinter() : Printer() {
    override fun printDoc(abstractPrint: String) {
       val words = abstractPrint.split("")
        for(item in words) {
            println("${Colors.BLACK}${Background.WHITE}$item${Colors.RESET}")
        }
    }
}

class InkjetPrinter : Printer() {
    private val palette = listOf(
        Colors.WHITE to Background.RED,
        Colors.BLACK to Background.YELLOW,
        Colors.WHITE to Background.BLUE,
        Colors.BLACK to Background.GREEN,
        Colors.WHITE to Background.PURPLE,
        Colors.BLACK to Background.CYAN
    )

    override fun printDoc(text: String) {
        val words = text.split(" ")
        for ((index, word) in words.withIndex()) {
            val (textColor, background) = palette[index % palette.size]
            println("$textColor$background$word${Colors.RESET}")
        }
    }
}

// Перегрузка методов

/*
4. Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
    1. Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
    2. Выполнить перегрузку addToCart который:
        1. Принимает два аргумента (itemId и количество amount)
        2. Принимает словарь из id и количества и добавляет всё в корзину
        3. Принимает список из id (добавляет по одной единице).
    3. Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
    4. Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
    5. Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая
       итоговое количество артикулов и общее количество всего товара в корзине.
*/

class Cart {
    private val items = mutableMapOf<String, Int>()   // id товара → количество

    // Базовый метод: одна единица товара
    fun addToCart(itemId: String) {
        addToCart(itemId, 1)
    }

    // Перегрузка 1: id и количество
    fun addToCart(itemId: String, amount: Int) {
        items[itemId] = items.getOrDefault(itemId, 0) + amount
    }

    // Перегрузка 2: словарь из id и количества
    fun addToCart(newItems: Map<String, Int>) {
        for ((itemId, amount) in newItems) {
            addToCart(itemId, amount)
        }
    }

    // Перегрузка 3: список id, каждый по одной единице
    fun addToCart(itemIds: List<String>) {
        for (itemId in itemIds) {
            addToCart(itemId)
        }
    }

    override fun toString(): String {
        return buildString {
            appendLine("Корзина:")
            appendLine("-".repeat(24))
            for ((itemId, amount) in items) {
                appendLine(itemId.padEnd(15) + amount.toString().padStart(9))
            }
            appendLine("-".repeat(24))
            appendLine("Артикулов: ${items.size}")
            append("Всего товаров: ${items.values.sum()}")
        }
    }
}

/*
5. Класс “Логгер”: представляет собой инструмент для вывода информации в консоль с разным префиксами
   уровня логирования (INFO, WARNING, ERROR, DEBUG)
    1. Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO
    2. Выполнить перегрузку метода log, который:
        1. Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом,
           а ERROR белым цветом на красном фоне.
        2. Принимает список сообщений и все их выводит с уровнем INFO
        3. Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR
    3. Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.
*/

class Logger {
    // Базовый метод: сообщение с уровнем INFO
    fun log(message: String) {
        println("[INFO] $message")
    }

    // Перегрузка 1: уровень и сообщение
    fun log(level: String, message: String) {
        when (level.uppercase()) {
            "WARNING" -> println("${Colors.YELLOW}[WARNING] $message${Colors.RESET}")
            "ERROR" -> println("${Colors.WHITE}${Background.RED}[ERROR] $message${Colors.RESET}")
            else -> println("[${level.uppercase()}] $message")
        }
    }

    // Перегрузка 2: список сообщений с уровнем INFO
    fun log(messages: List<String>) {
        for (message in messages) {
            log(message)
        }
    }

    // Перегрузка 3: исключение, выводится его message с уровнем ERROR
    fun log(exception: Exception) {
        log("ERROR", exception.message ?: "Неизвестная ошибка")
    }
}