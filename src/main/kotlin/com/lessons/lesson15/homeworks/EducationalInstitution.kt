package com.lessons.lesson15.homeworks

/* Для каждого задания опиши в коде базовый класс с базовыми свойствами и если применимо - методами.

Для производных классов также добавь специфичные для класса свойства. Детально описывать не нужно,
упражнение на то, чтобы усвоить иерархию наследования и развитие функциональности у наследников.
*/

/* 2. Учебные Заведения
    1. Базовый класс: Учебное Заведение
        1. Производные классы: Школа, …
            1. Дополнительное разветвление для …: …
*/

abstract class EducationalInstitution(val name: String, val address: String, val studentsCount: Int)

open class School(name: String, address: String, studentsCount: Int, val number: Int) :
    EducationalInstitution(name, address, studentsCount)

class University(name: String, address: String, studentsCount: Int, val faculties: List<String>) :
    EducationalInstitution(name, address, studentsCount)

class Gymnasium(name: String, address: String, studentsCount: Int, number: Int, val languages: List<String>) :
    School(name, address, studentsCount, number)

class Lyceum(name: String, address: String, studentsCount: Int, number: Int, val profile: String) :
    School(name, address, studentsCount, number)