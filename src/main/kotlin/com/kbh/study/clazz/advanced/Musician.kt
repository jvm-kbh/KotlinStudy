package com.kbh.study.clazz.advanced

/**
 * d
 * */

abstract class Musician(val name: String, val activeForm: Int) {
    abstract fun instrument(): String
}

class Cellist(name: String, activeForm: Int, etc: String) : Musician(name, activeForm) {
    override fun instrument() = "override instrument"
}

val ma = Cellist("Yo-Yo Ma", 1988, "some")