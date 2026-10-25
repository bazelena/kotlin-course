package com.lessons.lesson15.homeworks

// Производный класс 1-го уровня
class Circle(color: String, val radius: Double) : Shape("Круг", color) {
    override fun area(): Double = Math.PI * radius * radius
}