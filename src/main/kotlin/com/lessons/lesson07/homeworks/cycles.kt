package com.lessons.lesson07.homeworks

for (i in 20 downTo 1 ) {

    if (i % 2 == 0) {

        println(i)

    }

    for (i in 20 downTo 2 step 2){

        println(i) }

    for (a in 0 ..30 step 3) {
        println(a)
    }
    val index: Int = 13
    for (b in ..<index) {
        println(b)
    }
}