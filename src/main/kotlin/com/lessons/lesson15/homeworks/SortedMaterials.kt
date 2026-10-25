package com.lessons.lesson15.homeworks

// 6. Третий класс при добавлении строки должен отсортировать весь список материалов в алфавитном порядке
// включая добавляемый материал.

class SortedMaterials : Materials() {
    fun addSorted(material: String) {
        val all = extractMaterials() + material   // старые материалы плюс новый
        all.sorted().forEach { addMaterial(it) }  // сортируем и возвращаем
    }
}