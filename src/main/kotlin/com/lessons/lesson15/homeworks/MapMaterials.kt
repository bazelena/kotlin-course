package com.lessons.lesson15.homeworks

// 7. Четвёртый класс должен принимать словарь (ключи и значения строки).
// Каждая пара ключа и значения должна попадать в контейнер следующим образом - ключ в начало,
// значение в конец. Таким образом в начале должны быть ключи в обратном порядке, потом существующие
// материалы, потом все значения.

class MapMaterials : Materials() {
    fun addFromMap(map: Map<String, String>) {
        val existing = extractMaterials()
        map.keys.reversed().forEach { addMaterial(it) } // ключи задом наперёд
        existing.forEach { addMaterial(it) }            // старые материалы в середину
        map.values.forEach { addMaterial(it) }          // значения в конец
    }
}