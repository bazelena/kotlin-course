package com.lessons.lesson15.homeworks

// Разветвление Многоугольника
class Triangle(color: String, val base: Double, val height: Double) : Polygon("Треугольник", color, 3) {
    override fun area(): Double = 0.5 * base * height
}