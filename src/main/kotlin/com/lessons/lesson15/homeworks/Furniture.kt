package com.lessons.lesson15.homeworks

/* Для каждого задания опиши в коде базовый класс с базовыми свойствами и если применимо - методами.

Для производных классов также добавь специфичные для класса свойства. Детально описывать не нужно,
упражнение на то, чтобы усвоить иерархию наследования и развитие функциональности у наследников.
*/

/* 3. Иерархия Мебели
    1. Базовый класс: Мебель
        1. Производные классы: …
            1. Дополнительное разветвление для …: …
*/

abstract class Furniture(val material: String, val color: String)

class SeatingFurniture(material: String, color: String, val seats: Int) : Furniture(material, color)

abstract class StorageFurniture(material: String, color: String, val shelvesCount: Int) :
    Furniture(material, color)

class Wardrobe(material: String, color: String, shelvesCount: Int, val doorsCount: Int) :
    StorageFurniture(material, color, shelvesCount)

class Bookshelf(material: String, color: String, shelvesCount: Int, val maxBooks: Int) :
    StorageFurniture(material, color, shelvesCount)