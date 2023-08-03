package com.kbh.study.delegation.v2

/**
 * 잘못된 경로로 상속하는 케이스
 *
 * 만약 매니저가 자바 프로그래머만 관리하는 형태로 상속을 해버리는 경우 C#을 관리하는 형태로 확장할 수 없다.
 *
 * */
interface Worker {
    fun work()
    fun takeVacation()
}

open class JavaProgrammer : Worker {
    override fun work() = println("...write Java...")

    override fun takeVacation() = println("...code at the beach")

}

class CSharpProgrammer : Worker {
    override fun work() = println("...write C#...")

    override fun takeVacation() = println("...branch at the ranch")

}

class Manager : JavaProgrammer()