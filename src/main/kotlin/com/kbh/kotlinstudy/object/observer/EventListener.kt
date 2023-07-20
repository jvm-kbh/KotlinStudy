package com.kbh.study.`object`.observer

// 코틀린에서 옵저버의 명칭을 종종 Listener 로 칭한다
interface EventListener {
    fun onEvent(count: Int)
}