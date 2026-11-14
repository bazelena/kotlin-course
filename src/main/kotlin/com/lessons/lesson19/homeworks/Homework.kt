package com.lessons.lesson19.homeworks

// Требуется описать класс, интерфейс или функцию и реализовать предложенную логику в коде.

/*
1. Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент,
если он существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.
*/
fun <T> getMiddleElement(list: List<T>): T? {
    if (list.size % 2 == 0) {
        return null
    }
    return list[list.size / 2]
}

/*
2. Напиши класс ListHolder, который будет хранить список элементов типа T и иметь метод для добавления
нового элемента и получения всех элементов в виде неизменяемого списка.
*/
class ListHolder<T> {
    val example = mutableListOf<T>()
    fun add(ex: T) {
        example.add(ex)
    }
    fun getAll(): List<T> {
        return example.toList()
    }
}

/*
3. Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
    1. элементов одного типа в элементы другого типа
    2. списка элементов одного типа в список элементов другого типа
*/
interface Mapper<A, B> {
    fun transform(arg: A): B
    fun transform(item: List<A>): List<B>
}

/*
4. Создай класс PhrasesToListOfStrings и имплементируй интерфейс Mapper с типами String и List<String>.
Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов.
Метод преобразования списков с аналогичной механикой.
*/
class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun transform(arg: String): List<String> {
        return arg.split(" ")
    }

    override fun transform(item: List<String>): List<List<String>> {
        return item.map { arg ->
            arg.split(" ")

        }
    }
}

/*
5. Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и возвращает словарь,
в котором ключ и значения поменялись местами.
*/
fun <D, E> transposition(map: Map<D, E>): Map<E, D> {
    return map.map { (key, value) ->
        value to key
    }.toMap()
}

/*
6. Напиши интерфейс Validator с дженериком с функцией валидации, которая будет принимать элемент с типом дженерика
и возвращать булево значение.
*/
interface Validator<P> {
    fun validation(element: P): Boolean
}

/*
7. Создай класс StringValidator и имплементируй интерфейс Validator с типом String?.
Реализуй проверку, что строка не является null, не пустая и не состоит из одних пробелов.
*/
class StringValidator : Validator<String?> {
    override fun validation(element: String?): Boolean {
        return element != null && element.isNotBlank()
    }
}

/* 8. Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int.
Реализуй проверку, что число чётное.
*/
class OddValidator : Validator<Int> {
    override fun validation(element: Int): Boolean {
        return element % 2 ==0
    }
}

/*
9. Создай класс ListValidator с дженериком, ограниченным типом Number, имплементируй интерфейс Validator
типизированный по типу List с nullable типом дженерика класса
    1. Реализуй проверку:
       1. Ни один элемент списка не является null
       2. Ни один элемент приведённый к типу Double не равен 0.0
*/
class ListValidator<M : Number> : Validator<List<M?>> {
    override fun validation(element: List<M?>): Boolean {
        return element.none { it == null } &&
                element.none { it?.toDouble() == 0.0 }
    }
}