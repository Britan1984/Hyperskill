package encryptdecrypt

import java.io.File

fun nalichie(argum: String, argsArr: Array<String>): Boolean {
    return argum in argsArr
}

fun encryptUni(text: Array<Char>, key:Int):String{
    var encryptText =""
    var i = 0
    while (i < text.size){
        encryptText = encryptText.plus(text.get(i)+key)
        i++
    }
    return encryptText
}

fun decryptUni(text: Array<Char>, key:Int):String{
    var decryptText =""
    var i = 0
    while (i < text.size){
        decryptText = decryptText.plus(text.get(i)-key)
        i++
    }
    return decryptText
}

fun encryptShi(text: String, key: Int, mBukv: List<String>, bBukv: List<String>):String{
    var encryptText =""
    var i = 0
    while (i < text.length){
        if (mBukv.contains<Any>(text.get(i).toString())) {
            if (mBukv.size-key>=mBukv.indexOf(text.get(i).toString())) {
                encryptText = encryptText.plus(mBukv[mBukv.indexOf(text.get(i).toString()) + key])
            }
            else {
                encryptText = encryptText.plus(mBukv[mBukv.indexOf(text.get(i).toString()) - mBukv.size + key])
            }
            i++
        }

        else if (bBukv.contains<Any>(text.get(i).toString())) {
            if (bBukv.size-key>=bBukv.indexOf(text.get(i).toString())) {
                encryptText = encryptText.plus(bBukv[bBukv.indexOf(text.get(i).toString()) + key])
            }
            else {
                encryptText = encryptText.plus(bBukv[bBukv.indexOf(text.get(i).toString()) - bBukv.size + key])
            }
            i++
        }
        else {
            encryptText = encryptText.plus(text[i])
            i++
        }
    }
    return encryptText
}

fun decryptShi(text:String, key:Int, mBukv: List<String>, bBukv: List<String>):String{
    var decryptText =""
    var i = 0
    while (i < text.length){
        if (mBukv.contains<Any>(text.get(i).toString())) {
            if (mBukv.indexOf(text.get(i).toString())>=key) {
                decryptText = decryptText.plus(mBukv[mBukv.indexOf(text.get(i).toString()) - key])
            }
            else {
                decryptText = decryptText.plus(mBukv[mBukv.size -key + mBukv.indexOf(text.get(i).toString())])
            }
            i++
        }

        else if (bBukv.contains<Any>(text.get(i).toString())) {
            if (bBukv.indexOf(text.get(i).toString())>=key) {
                decryptText = decryptText.plus(bBukv[bBukv.indexOf(text.get(i).toString()) - key])
            }
            else {
                decryptText = decryptText.plus(bBukv[bBukv.size -key + bBukv.indexOf(text.get(i).toString())])
            }
            i++
        }
        else {
            decryptText = decryptText.plus(text[i])
            i++
        }
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
    var algoritm = "shift"
    var i=0
    val mBukv = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
    val bBukv = listOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")

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
    if (nalichie("-alg",args)){
        algoritm = args[args.indexOf("-alg") + 1]
    }



    while (i < text.length){
        chText += text[i]
        i++
    }

    when (algoritm){
        "unicode" -> when (change){
            "enc" -> encDecText = encryptUni(chText, key)
            "dec" -> encDecText = decryptUni(chText, key)
            else -> print("Error")
        }
        "shift" -> when (change){
            "enc" -> encDecText = encryptShi(text, key, mBukv, bBukv)
            "dec" -> encDecText = decryptShi(text, key, mBukv, bBukv)
            else -> print("Error")
        }
    }

    if (outText==""){
        println(encDecText)
    }
    else File(outText).writeText(encDecText)
}
