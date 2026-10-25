package com.lessons.lesson15.homeworks

// 4. Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)

class BottomMaterials : Materials() {
    fun addToBottom(material: String) {
        val existing = extractMaterials()   // вынули всё
        addMaterial(material)               // новый материал кладём первым — он окажется под индексом 0
        existing.forEach { addMaterial(it) } // возвращаем старые материалы поверх
    }
}