package encryptdecrypt

fun nalichie(argum: String, argsArr: Array<String>): Boolean {
    return argum in argsArr
}

fun encrypt(text: Array<Char>, key:Int){
    var encryptText =""
    var i = 0
    while (i < text.size){
        encryptText = encryptText.plus(text.get(i)+key)
        i++
    }
    print(encryptText)
}

fun decrypt(text: Array<Char>, key:Int){
    var decryptText =""
    var i = 0
    while (i < text.size){
        decryptText = decryptText.plus(text.get(i)-key)
        i++
    }
    print(decryptText)
}


fun main(args:Array<String>) {

    var change = "enc"
    var text = ""      //начальное сообщение
    var chText = emptyArray<Char>()
    var key = 0          //Ключ шифрования
    if(nalichie("-mode",args)) {
        change = args[args.indexOf("-mode") + 1]
    }
    if(nalichie("-key",args)){
        key = args[args.indexOf("-key")+1].toInt()
    }
    if(nalichie("-data",args)){
        text = args[args.indexOf("-data")+1]
    }
    var i=0
    while (i < text.length){
        chText += text[i]
        i++
    }

    when (change){
        "enc" -> encrypt(chText, key)
        "dec" -> decrypt(chText, key)
        else -> print("Ошибка выбора")
    }
}
