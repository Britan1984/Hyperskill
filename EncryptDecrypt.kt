package encryptdecrypt

fun main() {
    val text = "we found a treasure!"       //начальное сообщение
    val z1 = ('a'..'z').joinToString("").toMutableList()        //массив алфавита
    val z2 = z1.reversed()      //создаем еще один массив с перевернутым алфавитом из z1
    val z3 = mutableMapOf<String, String>()     //создаем пустой редактируемый MAP
    var description = ""        //шифровонное сообщение
    var i = 0       //счетчик
    while (i < z1.size){            //складываем  2 массива алфавита в 1 MAP
        z3.put(z1[i].toString(), z2[i].toString())
        i++
    }
    i = 0       //сбрасываем счетчик в 0
    while (i < text.length){        //цикл по длинне начального сообщения
        if (z3.contains(text.get(i).toString()))        //проверка на символы в MAP
            description = description.plus(z3.get(text.get(i).toString()))      //если символ есть в MAP то взять значение по ключю из символа начального текста
        else description = description.plus(text.get(i))        //если символа нет в MAP то просто дописать из начального сообщения
        i++
        }
    print(description)      //печатаем шифрованное сообщение
}
