package com.lessons.lesson15.homeworks

// Базовый класс: общее для всех фигур
abstract class Shape(val name: String, val color: String) {
    abstract fun area(): Double   // площадь есть у любой фигуры, но считается по-разному
}я