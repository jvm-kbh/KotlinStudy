package com.kbh.study.delegation.v3


/**
 * Manager 클래스를 델리게이션을 빌트인 기능으로 제공하지 않는 자바 스타일의 코딩으로 풀어낸 코드이다.
 *
 * open 키워드로 강하게 연결할 필요없이, Worker 인터페이스를 구현한 클래스의 인스턴스에게 위임이 가능하다.
 * 그러나 좋지 않은 점은 현재 구조상 Manager는 Worker의 인스턴스의 기능을 동일하게 호출하는 역활만한다.
 *
 * Worker의 메서드가 늘어날 수록 Manager에서도 동일한 호출코드가 생기므로 반복적인 요소를 증가시킨다.
 *
 * DRY(Don't Repeat Yourself) 원칙을 어기는 행위이다.
 *
 * 클래스를 확장을 하기위해 기존 클래스를 변경하는 것은 개방 폐쇠의 원칙 OCP(Open-Closed Principle)을 어기는 것이다.
 *
 * 이런 문제때문에 자바에선 델리게이션보다 상속을 선호하는 경향이 존재한다.
 *
 * 개념적으로도 Manager는 JavaProgrammer의 아니다
 *
 * 그렇다고 상속으로 풀어나가기엔 리스코프 치환의 법칙 LSP(Liskov Substitution Principle) 또한 위반이다.
 *
 * 코틀린에서는 이러한 문제를 언어수준에서 델리게이션으로 지원한다.
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
/**
 * 자바 스타일의 델리게이션 방식
 * */
class Manager(val worker: Worker) {
    fun work() = worker.work()
    fun takeVacation() = worker.work()
}

fun main(){
    val doe = Manager(JavaProgrammer())
    doe.work()
    //val coder : JavaProgrammer = doe  //type mismatch
}

