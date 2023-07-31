package com.kbh.study.clazz.advanced.remote.version2

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

class TV {
    var volume = 0
}

class TVRemote(val tv: TV) : Remote {
    override fun up() { tv.volume++ }
    override fun down() { tv.volume-- }
}

fun main(){
    val tv = TV()
    val remote: Remote = TVRemote(tv)
    println("Volumn: ${tv.volume}")
    remote.up()
    println("After increasing: ${tv.volume}")
    remote.doubleUp()
    println("After doubleUp: ${tv.volume}")

    val anotherTV = TV()
    val combinedRemote = Remote.combine(remote, TVRemote(anotherTV))
    combinedRemote.up()
    println(tv.volume)
    println(anotherTV.volume)
}