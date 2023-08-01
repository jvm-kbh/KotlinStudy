package com.kbh.study.clazz.advanced

/**
 * 코틀린은 기본적으로 자바와 다르게 클래스 설계자의 의도를 벗어나는 것을 방지한다
 * 코틀린에서 클래스는 디폴트로 'final' 이므로 클래스 설계자가 별도의 조치를 하지 않은 클래스를 베이스 클래스로 활용못한다.
 *
 * 'open' 키워드로 클래스 설계자는 상속받을 수 있도록 제공해야하며 클래스의 메서드를 활용하고자 한다면
 * override라 명시해야지만 해당 베이스 클래스의 메소드를 오버라이드 가능하다.
 *
 * 클래스 내부에 정의된 속성과 생성자에 정의된 속성 모두 override가 가능하다
 *
 * val로 정의된 속성은 val, var 를 모두 활요하여 override가 가능하다. 이는 val가 getter만 가지고 있고
 * 자식 클래스에서 var로 override 하면서 setter를 생성할 수 있다
 *
 * var로 정의된 속성은 오직 var로만 가능하다. 이는 val로 override 하려고하면 setter를 제거할 수 없기 때문이다.
 *
 *
 * */
open class Vehicle(val year:Int, open var color: String) {
    open val km = 0
    final override fun toString() = "$year, $color, $km"
    fun repaint(newColor: String){
        color = newColor
    }
}

/**
 * Vehicle을 파생하여 Car로 생성되는 인스턴스들이 특정한 규칙에 의해 km을 저장하도록 구성한다
 * 규칙에 통과하면 km 프로퍼티의 백킹 필드에 전달 되도록 구성된다.
 *
 * 또한 Car만의 특성을 위해 drive 메서드는 open 키워드를 붙이지 않으며 final로 처리된다
 *
 * 자바와 다르게 코틀린에서 implements, extends 키워드로 구분하지 않고 사용하며 개념도 inheritance로 통일되게 표현한다
 * 그러나 사용시에 추상 클래스는 동일하게 하나만 가질 수 있다
 * */
open class Car(year: Int, color: String) : Vehicle(year, color) {
    override var km: Int = 0
        set(value) {
            if (value < 1){
                throw RuntimeException("can't set negative vale")
            }
            field = value
        }

    fun drive(distance: Int){
        km += distance
    }
}

/**
 * Car와 다르게 color 속성을 저장하지 않고 getter, setter를 오버라이드하여 베이스 클래스에 값을 활용한다.
 * 왜나하면 color을 Car 클래스에서 override하지 않았기때문에 Vehicle 클래스의 color 속성을 사용한다.
 *
 * 코틀린에서 오버라이딩을 할 때 접근권한에 관한 제약사항이 좀 더 관대하고 느슨하게 만둘 수 있다.
 * private, protected 멤버를 자식클래스에서 public으로 만들 수 있다. 그러나 이 반대의 경우에는 그렇지 못하다.
 * */
class FamilyCar(year: Int, color: String) : Car(year, color){
    override var color: String
        get() = super.color
        set(value) {
            if (value.isEmpty()){
                throw RuntimeException("Color required")
            }
            super.color = value
        }
}