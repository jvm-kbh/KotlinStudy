package com.kbh.study.clazz

// 클래스 선언부에 생성자 키워드를 생략이 가능하다
class KotlinConstructor constructor(var name: String, var birthYear: Int) {
    /**
     * 코틀린의 기본 생성자이며 파라미터 및 반환형이 없다.
     * 가급적이면 사용하지 않는편이 프로그램의 안정성과 퍼포먼스 측면 모두에서 장정이 더 크다
     * */
    init {
        println("${this.name}, ${this.birthYear}")
    }

    /**
     * 보조 생성자 생성시 반드시 기본 생성자를 통해 속성을 초기화해야하며, ': this' 를 기술한다.
     * 또한 프로퍼티를 정의할 수 없다. var, val키워드를 활용할 수 없으므로 파라미터만 생성이 가능하다
     * 주 생성자와 클래스 내부의 속성을 정의할 수 있다.
     */
    constructor(name: String) : this(name, 1988) {
        println("보조 생성자사 생성됨")
    }
}

fun main() {
    KotlinConstructor("김보훈",1888)
    KotlinConstructor("김보훈")
    KotlinConstructor("배창현")
    KotlinConstructor("황성인")
}