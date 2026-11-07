package com.lessons.lesson17.homeworks

// Нужно скопировать код к себе и постараться ответить на все “почему” в комментариях
// и заданным образом доработать класс ChildrenClass (BaseClass доработке не подлежит)

abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
    /* Ответ:
    Потому что в ChildrenClass объявлено своё публичное поле val privateVal.
    В main() читается оно, а не приватное поле BaseClass: это два разных поля с одинаковым именем и значением.
    */
    private val privateVal: String,

    // 2. объясни, почему это поле недоступно в main()
    /*
    Ответ: Потому что `protected` виден только внутри класса и его наследников, а `main()` к ним не относится.
    В `ChildrenClass` `protectedVal` объявлен без `val`, поэтому публичного поля у наследника нет.
     */
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }
    fun printText() {
        privatePrint()
    }

class Why {
}
    // 7. объясни, почему эта функция не может быть публичной
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }
    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }
    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }
    // 9. объясни, почему эта функция не может быть публичной или protected
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}
class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {

    // Публичное свойство с сеттером, который меняет protectedField родителя
    var editableProtectedField: String
        get() = protectedField
        set(value) {
            protectedField = value
        }

    // Переопределяем проверку, чтобы сеттер publicField принял длинное значение
    override fun verifyPublicField(value: String): Boolean {
        return true
    }

    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
}