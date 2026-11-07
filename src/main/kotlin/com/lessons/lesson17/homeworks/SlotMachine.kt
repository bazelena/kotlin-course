package com.lessons.lesson17.homeworks

/*
Игровой автомат

Опиши схематически класс игрового автомата, правильно расставив объявление полей (val или var)
и методов (аргументы и возвращаемые значения), включая модификаторы доступа (private для приватных)

Поля:
    - цвет
    - модель
    - включен
    - ОС загружена
    - список установленных игр
    - наличие джойстика
    - баланс вырученных средств
    - владелец
    - телефон поддержки
    - игровой сеанс оплачен
    - стоимость одного игрового сеанса
    - пин-код автомата

Методы:
    включить
    выключить
    загрузить ОС
    завершить работу ОС
    показать список игр
    включить игру
    оплатить игровой сеанс
    забрать наличные с помощью пин-кода
    открыть сейф и выдать наличные
 */

class GameMachine(val color: String, val model: String, val hasJoystick: Boolean) {
    var isOn = false // ОС загружена
        private set
    var isOsLoaded = false
    private val games = mutableListOf("Tetris", "Mario") //  список установленных игр
    private var balance = 0.0 // баланс вырученных средств
    val owner = "" // владелец
    var supportPhone = "" // телефон поддержки
    private var isSessionPaid = false // игровой сеанс оплачен
    val sessionPrice = 0.00 //  стоимость одного игрового сеанса
    private var pin = "" // пин-код автомата


    fun turnOn() {
        isOn = true
        loadOs()
    }

    fun turnOff() {
        shutDownOs()
        isOn = false
    }

    private fun loadOs() {
        isOsLoaded = true
        println("ОС загружена")
    }

    private fun shutDownOs() {
        isOsLoaded = false
        println("Работа ОС завершена")
    }

    fun showGames(): List<String> = games.toList()

    fun play(gameName: String) {
        if (!isSessionPaid) {
            println("Оплати игру прежде чем начать")
            return
        }
        if (gameName !in games) {
            println("Игра '$gameName' не найдена")
            return
        }
        println("Игра '$gameName' запущена")
        isSessionPaid = false
    }

    fun pay() {
        balance += sessionPrice.toDoubleOrNull() ?: 0.0
        isSessionPaid = true
    }

    fun withdraw(pin: String): Double {
        if (pin != this.pin) {
            return 0.0
        }
        return openSafe()
    }

    private fun openSafe(): Double {
        val withdraw = balance
        balance = 0.0
        return withdraw
    }
}