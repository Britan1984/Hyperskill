package chucknorris

import java.lang.StringBuilder

fun main() {
    println("Input string:")
    val text = readln()
    val textArr = arrayListOf<String>()
    var hexText = ""
    for (i in text){
        textArr.add(i.toString())
    }
    println("The result:")
    for (i in textArr) {
        var hexChar = StringBuilder().append(Integer.toBinaryString(i.single().code))
        var hexString = hexChar.toString()
        while (true) {
            if (hexString.length < 7) {
                hexString = "0" + hexString
            } else break
        }
        hexText += hexString
    }
    var tempHexNum = "2"
    for (i in hexText){
        if (tempHexNum.equals("2")) {
                if(i.toString().equals("1")) print("0 0")
                else if (i.toString().equals("0")) print("00 0")
                tempHexNum = i.toString()
        }
        else {
            if (tempHexNum.equals(i.toString())){
                print("0")
            }
            else {
                if (i.toString().equals("0")) print(" 00 0")
                else if (i.toString().equals("1")) print(" 0 0")
            }
            tempHexNum = i.toString()

        }
    }
}
