package encryptdecrypt

fun encrypt(text:CharArray, key:Int){
    var encryptText =""
    var i = 0
    while (i < text.size){
        encryptText = encryptText.plus(text.get(i)+key)
        i++
    }
    print(encryptText)
}

fun decrypt(text:CharArray, key:Int){
    var decryptText =""
    var i = 0
    while (i < text.size){
        decryptText = decryptText.plus(text.get(i)-key)
        i++
    }
    print(decryptText)
}


fun main() {
    val change = readln()
    val text = readln().toCharArray()      //начальное сообщение
    val key = readln().toInt()          //Ключ шифрования
    when (change){
        "enc" -> encrypt(text, key)
        "dec" -> decrypt(text, key)
        else -> print("Ошибка выбора")
    }
}
