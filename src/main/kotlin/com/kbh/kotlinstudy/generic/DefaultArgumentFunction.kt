package com.kbh.kotlinstudy.generic

fun main() {
    defaultArgumentFunction("짬뽕")
    defaultArgumentFunction("짜장", 2, "당구장")
}

/**
 * 함수에 별다른 값을 파라미터로 넘기지 않아도 작동해야되는 경우라면 다음과 같이 파라미터에 디폴트 값을 할당할 수 있다.
 * 사용해야 되는 경우가 있나 싶긴한데 특정 함수가 자체적으로 처리하기보단, 요청 값 앞단에서 vaild하여 처리할 것이다.
 */
fun defaultArgumentFunction(name: String, count: Int = 1, destination: String = "집") {
    println("$name, $count, $destination")
}