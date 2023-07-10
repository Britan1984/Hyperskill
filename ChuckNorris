package chucknorris

import java.lang.StringBuilder

fun main() {
    println("Input string:")
    val text = readln().toCharArray()
    println("The result:")
    for (i in text) {
        var hexChar = StringBuilder().append(Integer.toBinaryString(i.toInt()))
        var hexString = hexChar.toString()
        while (true) {
            if (hexString.length < 7) {
                hexString = "0" + hexString
            } else break
        }
        println("$i = $hexString")
    }
}
