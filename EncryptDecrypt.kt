package encryptdecrypt

fun main() {
    val text = readln().toString()       //начальное сообщение
    val key = readln().toInt()          //Ключ шифрования
    val z1 = ('a'..'z').joinToString("").toMutableList()        //массив алфавита
    var description = ""        //шифровонное сообщение
    var i = 0       //счетчик
    while (i < text.length) {       //цикл на длинну текста
        if (z1.contains(text.get(i))) {     //проверка что массив содержит символ из текста
            if (z1.indexOf(text.get(i)) + key < z1.size) {      //проверка что индекс символа текста + ключ не превышают длинну массива (алфавита)
                description = description.plus(z1.get(z1.indexOf(text.get(i)) + key)) // шифруем символ добавив к индексу символа ключ и по новому индексу взяли новый символ из массива
            } else description = description.plus(z1.get(z1.indexOf(text.get(i)) + key - z1.size))  //если индекс символа текста + ключ превышают длинну массива (алфавита) и шифруем его
        }
        else description = description.plus(text.get(i))    // записываем символы которые не содержатся в массиве
        i++
    }
    print(description)      //печатаем шифрованное сообщение
}
