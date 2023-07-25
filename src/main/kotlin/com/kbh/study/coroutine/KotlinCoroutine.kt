package com.kbh.study.coroutine

import kotlinx.coroutines.*

/**
 * 코루틴은 코틀린에서만 쓰이는 것이 아닌 다양한 분야에서 쓰이고 있다.
 * 비동기적인 프로세스를 처리하기 위해 메인이 되는 루틴에서 서브 역활을 하는 코루틴을 두어 개발자가 제어함에 목적이 있다.
 * 제어범위, 실행범위를 지정할 수 있고 이것을 스코프라고 한다.
 * 전체적인 스코프는 GlobalScope, 특정 목적을 위해는 CoroutineScope 를 통해 활용된다.
 * Scope 내에서 동작을 제어하기 위하여 여러종류의 Dispatcher 를 지정하여 활용하나 모든 플랫폼에서 지원하지 않으므로
 * 잘 확인하고 적용해야한다.
 * Scope에 반환값 유무에 따라 반환값이 없는 job 객체 launch, 반환값이 있는 Deffered async() 가 존재하고 람다함수의 형태를 취한다.
 */
fun main() {
    /**
     * 일정한 범위 내에서 실행이 되도록 보장하려면 blocking 을 수행해야한다
     * cancel() 을 활용하여 코루틴을 2가지 경우로 따져서 종료시킬수 있다.
     * 1. delay(), yield() 가 사용된 위치까지 수행하되고 종료
     * 2. cancel()로 인하여 코루틴의 프로퍼티 isActive = false 가 되므로 이를 수동으로 확인하여 종료
     */
    /*runBlocking {

        val launch = launch {
            for (i in 1..10){
                println(i)
                delay(10)
            }
        }
        val async = async {
            println("async 종료")
        }
        println("async 대기")
        println(async.await())
        println("launch 대기")
        launch.join()
        println("launch 종료")
    }*/
    // 재시간내에 수행을 못하면 null 을 반환한다.
    /*runBlocking {
        val result = withTimeoutOrNull(50) {
            for (i in 1..10) {
                println(i)
                delay(10)
            }
            "finish" // return
        }
        println(result)
    }*/
}