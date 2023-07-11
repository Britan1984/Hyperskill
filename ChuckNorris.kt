package chucknorris

import kotlin.text.StringBuilder

fun encoder() {
    println("Input string:")
    val inputText = readln()
    val textArr = arrayListOf<String>()
    var text = ""
    for (i in inputText){
        textArr.add(i.toString())
    }
    var hexText = ""
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
    for (i in hexText) {
        if (tempHexNum.equals("2")) {
            if (i.toString().equals("1")) text += "0 0"
            else if (i.toString().equals("0")) text += "00 0"
            tempHexNum = i.toString()
        } else {
            if (tempHexNum.equals(i.toString())) {
                text += "0"
            } else {
                if (i.toString().equals("0")) text += " 00 0"
                else if (i.toString().equals("1")) text += " 0 0"
            }
            tempHexNum = i.toString()
        }
    }
    println("Encoded string:")
    println(text)
    main()
}
fun decoder(){
    println("Input encoded string:")
    val inputText = readln()
    var text = ""
    val arrNum = inputText.split(" ")
    for (i in 0 .. arrNum.size-1 step 2){
        if (arrNum[i].equals("0")){
            for (x in 1..arrNum[i+1].length) text+=1
        }
        else if (arrNum[i].equals("00")){
            for (x in 1..arrNum[i+1].length) text+=0
        }
    }
    val arrText = arrayListOf<Int>()
    for (i in 1..text.length/7){
        if (i == 1){
                arrText.add(text.substring(startIndex = 0, endIndex = 7*i).toInt(2))
        }
        else arrText.add(text.substring(startIndex = 7*(i-1), endIndex = 7*i).toInt(2))
    }
    text =  ""
    for (j in arrText){
        text += j.toChar()
    }

    println("Decoded string:")
    println(text)
    main()
}
fun main() {
    println("Please input operation (encode/decode/exit):")
    val operation = readln()
    when (operation) {
        "encode" -> encoder()
        "decode" -> decoder()
        "exit" -> {
            println("Bye!")
            System.exit(0)
        }
    }
}
