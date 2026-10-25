package com.lessons.lesson15.homeworks

class Quadrilateral(color: String, val width: Double, val length: Double) : Polygon("Четырехугольник", color, 4) {
    override fun area(): Double = width * length
}