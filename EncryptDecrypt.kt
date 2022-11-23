package encryptdecrypt

import java.io.File

fun nalichie(argum: String, argsArr: Array<String>): Boolean {
    return argum in argsArr
}

fun encrypt(text: Array<Char>, key:Int):String{
    var encryptText =""
    var i = 0
    while (i < text.size){
        encryptText = encryptText.plus(text.get(i)+key)
        i++
    }
    return encryptText
}

fun decrypt(text: Array<Char>, key:Int):String{
    var decryptText =""
    var i = 0
    while (i < text.size){
        decryptText = decryptText.plus(text.get(i)-key)
        i++
    }
    return decryptText
}



fun main(args:Array<String>) {

    var change = "enc"
    var text = ""      //начальное сообщение
    var chText = emptyArray<Char>()
    var key = 0          //Ключ шифрования
    var encDecText = ""
    var inText = ""
    var outText = ""

    if(nalichie("-mode",args)) {
        change = args[args.indexOf("-mode") + 1]
    }
    if(nalichie("-key",args)){
        key = args[args.indexOf("-key")+1].toInt()
    }
    if(nalichie("-data",args)){
        text = args[args.indexOf("-data")+1]
    }
    if(nalichie("-in",args)&&text==""){
        inText= args[args.indexOf("-in") + 1]
        text = File(inText).readText()
    }
    if(nalichie("-out",args)){
        outText = args[args.indexOf("-out") + 1]
    }

    var i=0

    while (i < text.length){
        chText += text[i]
        i++
    }

    when (change){
        "enc" -> encDecText = encrypt(chText, key)
        "dec" -> encDecText = decrypt(chText, key)
        else -> print("Error")
    }

    if (outText==""){
        println(encDecText)
    }
    else File(outText).writeText(encDecText)
}
