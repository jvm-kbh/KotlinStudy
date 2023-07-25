package com.kbh.study.clazz

fun main() {
    val bathRoom = BathRoom()
    val terrace = Terrace()
    bathRoom.enter()
    bathRoom.eat()
    terrace.enter()
    terrace.eat()
}
abstract class Room {
    abstract fun eat()
    fun enter(){
        println("방에 입장")
    }
}

class BathRoom : Room() {
    override fun eat() {
        println("식사하기 어려운 곳이다")
    }
}

class Terrace : Room() {
    override fun eat() {
        println("고급 과자를 먹는다")
    }
}