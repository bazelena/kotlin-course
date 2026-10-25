package com.lessons.lesson15.homeworks

// 5. Второй класс должен получать список строк и вставлять их в начало контейнера,
// но поочерёдно с теми данными, которые уже есть. То-есть, наш список должен появиться
// в контейнере по индексам 0, 2, 4 и так далее.

class InterleaveMaterials : Materials() {
    fun addInterleaved(newMaterials: List<String>) {
        val existing = extractMaterials()
        val maxSize = maxOf(newMaterials.size, existing.size)
        for (i in 0 until maxSize) {
            if (i < newMaterials.size) addMaterial(newMaterials[i]) // новый
            if (i < existing.size) addMaterial(existing[i])         // старый
        }
    }
}