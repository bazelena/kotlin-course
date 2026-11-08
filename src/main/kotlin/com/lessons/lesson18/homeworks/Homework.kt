package com.lessons.lesson18.homeworks

import java.io.InputStream

// Интерфейсы для работы

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

/* Задача 1. Создай абстрактные классы устройств, используя эти интерфейсы.
Реализовывать методы не нужно.

    - Холодильник
    - Стиральная машина
    - Умная лампа
    - Электронные часы
    - Робот-пылесос
    - Механические часы
    - Фонарик
    - Кофемашина
    - Умная колонка

 */

abstract class Refrigerator () : Powerable, TemperatureRegulatable, LightEmitting, Programmable, Rechargeable
abstract class WashingMachine () : Powerable, Openable, WaterContainer, TemperatureRegulatable, WaterConnection, AutomaticShutdown, Drainable, Timable, SoundEmitting, Programmable, Cleanable
abstract class SmartLamp () : Powerable, Timable, Mechanical, LightEmitting, Programmable, Rechargeable
abstract class ElectronicClock () : Powerable, Timable, BatteryOperated, Mechanical, LightEmitting, SoundEmitting, Programmable, Rechargeable
abstract class RobotVacuum () : Powerable, Openable, WaterContainer, AutomaticShutdown, Timable, BatteryOperated, Mechanical, SoundEmitting, Programmable, Movable, Cleanable, Rechargeable
abstract class MechanicalWatch () : Mechanical
abstract class Flashlight () : Powerable, BatteryOperated, Mechanical, LightEmitting, Rechargeable
abstract class CoffeeMachine () : Powerable, Openable, WaterContainer, TemperatureRegulatable, AutomaticShutdown, Timable, Mechanical, SoundEmitting, Programmable, Cleanable, Rechargeable
abstract class SmartSpeaker () : Powerable, AutomaticShutdown, Timable, BatteryOperated, LightEmitting, SoundEmitting, Programmable, Rechargeable


/* Задача 2. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс
с реализацией методов (достаточно println с выполняемым действием).
 */

abstract class PoweredDevice(val name: String) : Powerable {

    var isOn = false
        private set

    override fun powerOn() {
        isOn = true
        println("$name: включено")
    }

    override fun powerOff() {
        isOn = false
        println("$name: выключено")
    }
}

/* Задача 3. Создай абстрактный класс для программируемого оборудования
(с имплементацией соответствующего интерфейса и реализацией методов)
и наследуй его от абстрактного класса включаемого оборудования.
 */

abstract class ProgrammableEquipment(name: String) : PoweredDevice(name), Programmable {

    private var program = ""

    override fun programAction(action: String) {
        if (!isOn) {
            println("$name: нельзя задать режим, устройство выключено")
            return
        }
        program = action
        println("$name: установлен режим «$action»")
    }

    override fun execute() {
        if (!isOn) {
            println("$name: нельзя запустить режим, устройство выключено")
            return
        }
        if (program.isEmpty()) {
            println("$name: режим не выбран")
            return
        }
        println("$name: выполняется режим «$program»")
    }
}

/* Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться
и с наследованием от программируемого оборудования. Также имплементируй интерфейсы.
 */

abstract class TemperatureOpenableEquipment(name: String) :
    ProgrammableEquipment(name), TemperatureRegulatable, Openable {

    override fun setTemperature(temp: Int) {
        if (!isOn) {
            println("$name: нельзя установить температуру, устройство выключено")
            return
        }
        if (temp > maxTemperature) {
            println("$name: $temp°C выше максимума ($maxTemperature°C)")
            return
        }
        println("$name: установлена температура $temp°C")
    }

    override fun open() {
        println("$name: открыто")
    }

    override fun close() {
        println("$name: закрыто")
    }
}

/* Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью устанавливать
температуру и открываться. Пусть это будет холодильник, стиральная машина, чайник, духовка.
Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия).
Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы)
не имеет смысла при выключенном питании - добавь эту проверку.
 */
class Ref : TemperatureOpenableEquipment("Холодильник"), LightEmitting {

    override val maxTemperature = 8

    override fun open() {
        super.open()
        emitLight()
    }

    override fun close() {
        super.close()
        completeLiteEmission()
    }

    override fun emitLight() {
        println("$name: включилась подсветка")
    }

    override fun completeLiteEmission() {
        println("$name: подсветка выключилась")
    }
}

class WashMachine : TemperatureOpenableEquipment("Стиральная машина"),
    WaterConnection, Drainable, Timable {

    override val maxTemperature = 90

    override fun connectToWaterSupply() {
        println("$name: подключена к водопроводу")
    }

    override fun getWater(amount: Int) {
        println("$name: набирает $amount л воды")
    }

    override fun connectToDrain() {
        println("$name: подключена к канализации")
    }

    override fun drain() {
        println("$name: сливает воду")
    }

    override fun setTimer(time: Int) {
        println("$name: таймер на $time мин")
    }
}

class Kettle : TemperatureOpenableEquipment("Чайник"), WaterContainer, AutomaticShutdown {

    override val maxTemperature = 100
    override val capacity = 1700
    override val sensorType = "температура"
    override val maxSensoredValue = 100

    override fun fillWater(amount: Int) {
        if (amount > capacity) {
            println("$name: столько не поместится, максимум $capacity мл")
            return
        }
        println("$name: налито $amount мл")
    }

    override fun getWater(amount: Int) {
        println("$name: налито в чашку $amount мл")
    }

    override fun startMonitoring() {
        println("$name: датчик «$sensorType» следит, отключение при $maxSensoredValue°C")
    }
}

class Oven : TemperatureOpenableEquipment("Духовка"), Timable, LightEmitting {

    override val maxTemperature = 250

    override fun setTimer(time: Int) {
        println("$name: таймер на $time мин")
    }

    override fun emitLight() {
        println("$name: включилась подсветка")
    }

    override fun completeLiteEmission() {
        println("$name: подсветка выключилась")
    }
}

// Создай объекты этих устройств и позапускай их с различными методами.

fun main() {
    val fridge = Ref()
    fridge.setTemperature(4)          // нельзя: выключен
    fridge.powerOn()
    fridge.setTemperature(15)         // выше максимума
    fridge.setTemperature(4)
    fridge.open()                     // открыто + подсветка
    fridge.close()                    // закрыто + подсветка выключилась
    println()

    val washer = WashMachine()
    washer.programAction("Хлопок")    // нельзя: выключена
    washer.powerOn()
    washer.connectToWaterSupply()
    washer.connectToDrain()
    washer.programAction("Хлопок")
    washer.setTemperature(40)
    washer.setTimer(90)
    washer.getWater(15)
    washer.execute()
    washer.drain()
    washer.powerOff()
    println()

    val kettle = Kettle()
    kettle.open()
    kettle.fillWater(2000)            // не поместится
    kettle.fillWater(1500)
    kettle.close()
    kettle.powerOn()
    kettle.setTemperature(100)
    kettle.startMonitoring()
    kettle.getWater(250)
    kettle.powerOff()
    println()

    val oven = Oven()
    oven.powerOn()
    oven.programAction("Конвекция")
    oven.setTemperature(300)          // выше максимума
    oven.setTemperature(180)
    oven.setTimer(40)
    oven.emitLight()
    oven.execute()
    oven.powerOff()
    oven.execute()                    // нельзя: выключена
}