package com.lessons.lesson15.homeworks

// Создай подклассы этого контейнера, которые будут добавлять строку material (или коллекции или словари строк) ё
// в какое-то определённое место (места).

abstract class Materials {
    private val materials = mutableListOf<String>()
    fun addMaterial(material: String) {
        materials.add(material)
    }
    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }
    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}