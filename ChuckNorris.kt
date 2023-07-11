package chucknorris

import kotlin.text.StringBuilder

fun encoder(textArr: ArrayList<String>) {
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
            if (i.toString().equals("1")) print("0 0")
            else if (i.toString().equals("0")) print("00 0")
            tempHexNum = i.toString()
        } else {
            if (tempHexNum.equals(i.toString())) {
                print("0")
            } else {
                if (i.toString().equals("0")) print(" 00 0")
                else if (i.toString().equals("1")) print(" 0 0")
            }
            tempHexNum = i.toString()

        }
    }
}
fun decoder(textArr: String):String {
    var text = ""
    val arrNum = textArr.split(" ")
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

    return text
}
fun main() {
    println("Input string:")
    val text = readln()
    val textArr = arrayListOf<String>()

    for (i in text){
        textArr.add(i.toString())
    }
    println("The result:")
    print(decoder(text))
    //print(encoder(textArr))
}
