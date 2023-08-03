package com.kbh.study.delegation.v1

/**
 * 기업의 소프트웨어 프로젝트를 시뮬레이션하기 위한 도메인을 설계한다
 * Worker 인터페이스를 통해 일(work), 휴식(take a vacation) 행위를 할 수있는
 * Java, C# 프로그래머를 구현했다.
 *
 * polyglot(다양한 언어로 코드를 작성) 하는 프로그래머는 없다고 가정하여 각자의 행위만 수행하도록 한다
 *
 * 팀을 관리하기위한 소프트웨어 매니저에 대한 클래스를 만들고 이것으로 델리게이션을
 * 실천하는 베이스 설계를 마치고 다음 버전에서 이어서 상황별로 설계를 진행한다.
 *
 * */
interface Worker {
    fun work()
    fun takeVacation()
}

class JavaProgrammer : Worker {
    override fun work() = println("...write Java...")

    override fun takeVacation() = println("...code at the beach")

}

class CSharpProgrammer : Worker {
    override fun work() = println("...write C#...")

    override fun takeVacation() = println("...branch at the ranch")

}

class Manager