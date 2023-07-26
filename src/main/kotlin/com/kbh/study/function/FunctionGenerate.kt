package com.kbh.study.function

fun main() {}

/**
 * 코틀린은 함수를 정의시 Kiss(Keep it Simple, Stupid) 원칙을 준수한다
 * 단순하게 방해요소 없이 수행에 있어 실수가 없도록 정의하는 원칙이다.
 */
fun kissFUnction() = "kiss"

/**
 * 컴파일시 리턴타입이 추론되어 구지 정의할 필요가 없으나 외부에서 사용되거나 좀 복잡해진다면 다음과 같이 리턴타입을 명확하게 기술하자
 * 그래야만 다른 인터페이스의 구현에 의해서 다른 타입으로 변형되는 것을 방지하며, 명확하게 자료형을 확인하여 가독성이 좋아진다.
 */
fun greet(): String = "hello"