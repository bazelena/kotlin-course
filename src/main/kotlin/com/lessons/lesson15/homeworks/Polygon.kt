package com.lessons.lesson15.homeworks

// Производный класс 1-го уровня. Тоже abstract: от него наследуются Треугольник и Четырехугольник
abstract class Polygon(name: String, color: String, val sidesCount: Int) : Shape(name, color)