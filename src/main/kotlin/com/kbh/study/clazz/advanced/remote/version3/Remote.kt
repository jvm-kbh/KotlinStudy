package com.kbh.study.clazz.advanced.remote.version3

interface Remote {
    fun up()
    fun down()
    fun doubleUp() {
        up()
        up()
    }

    companion object {
        fun combine(first: Remote, second: Remote): Remote = object : Remote {
            override fun up() {
                first.up()
                second.up()
            }

            override fun down() {
                first.down()
                second.down()
            }
        }
    }
}

/*class TV {
    var volume = 0
}

class TVRemote(val tv: TV) : Remote {
    override fun up() { tv.volume++ }
    override fun down() { tv.volume-- }
}*/

/**
 * TV의 이전 설계에서 TV로 직접 Remote 인터페이스를 구현하지 않고 별도로 TVRemote에서 TV를 가지고 있는 점은
 * 직접 구현하느냐 분리된 클래스로 구현하느냐의 차이인데 각기 장단점이 존재한다.
 *
 * TV 인스턴스가 여러개의 TVRemote를 여러 개 가질 수 있고 이러한 디자인은 각기 다른 제어자(예를 들어 스레드)가
 * 서로의 영향을 받지 않고 tv의 볼륨을 제어가 가능하는 점이다.
 *
 * 그리고 각기 TVRemote TV에 영향을 받지않고 독자적인 내부 상태를 가질 수 있도록 디자인이 가능하다.
 * 가령 여러개의 리모콘 중 하나의 리모콘에만 불이 들어오는 상황을 만들 수 있다.
 *
 * 다만 단점으로는 인터페이스를 구현하는데 단점이 있다.
 * Remote 인터페이스를 구현하는 TVRemote의 메서드는 TV의 public 메서드로 사용해야한다.
 *
 * TV가 Remote 인터페이스를 직접 구현하고 있는경우 다음의 장점이 생긴다
 * - public 메서드에 의존할 필요가 없어진다
 * - 내부에서만 활용되는 요소를 효율적으로 사용하게 된다.
 * - TVRemote처럼 내부에 TV를 참조 추가할 필요가 없다.
 *
 * 위와같은 상황에서 장점을 유지하면서 단점을 피하는 디자인 옵션으로 내부 클래스(Innner Class)를 활용하는 방법이다.
 * java와 다른점은 inner 키워드를 통해야지만 외부클래스의 통해 private 멤버에 접근이 가능하다
 *
*/
class TV {
    private var volume = 0
    val remote: Remote
        // 이 속성은 매번 호출시 마다 새로운 인스턴스를 리턴하도록 디자인 되어있다.
        get() = TVRemote()

    override fun toString(): String {
        return "Volume : ${volume}"
    }

    inner class TVRemote : Remote {
        override fun up() { volume++ }

        override fun down() { volume-- }

        // this : TVRemote, this@TV : TVRemote 클래스인 외부 클래스 TV
        // super@OuterClass : 더 상위에 외부 클래스(Any) 에 접근하고 싶은경우는 사용하나 자주하면 다형성과 메서드 오버라이드의 의도를 해치게 된다.
        override fun toString(): String = "Remote : ${this@TV.toString()}"
    }
}

fun main() {
    val tv = TV()
    val remote = tv.remote
    println("$tv")
    remote.up()
    println("After increasing : $tv")
    remote.doubleUp()
    println("After doubleUp : $tv")
}
