package com.kbh.study.`object`.observer

/**
 * Observer Pattern을 학습하며 코틀린에서의 익명객체의 활용을 학습한다.
 * 직접적인 함수의 호출이 아닌 상황에서 특정 이벤트가 발생한 경우 즉각적으로 처리하는 패턴을 옵저버 패턴이라 부른다.
 *
 * EventPrinter가 EventListener를 override 하지 않아도 이벤트 객체를 Anonymous Object 로 넘길 수 있다.
 * 코드 중간에 익명 객체를 통해서 구현부 까지 넣는 행위는 한개의 파라미터 값을 넣기위해 많은 코드량이 필요하고 가독성이 떨어지므로
 * 개인적으로 선호하지 않는 방식이므로 특별한 경우가 아니면 사용하지 않을것이다.
 */
fun main() {
    EventPrinter().start()
    //AnonymousEventPrinter().start() -- 별로 선호하지 않는다.
}