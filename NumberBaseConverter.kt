package converter

import kotlin.math.pow

fun main() {
    var vvod1 = ""
    var vvod2 = ""
    var tempLeftDec = ""
    var tempRightDec = ""
    var leftInt = ""
    var rightInt = ""
    var drobIn10 = 0.0
    var tempDrobTarget = ""

    while (vvod1 != "/exit") {                                                               //кольцо до /Exit
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit) > ")
        vvod1 = readln()                                                                    //Читаем Исходную и Таргет базы
        if (vvod1 != "/exit") {                                                             //Проверка на /Exit
            val (source_b, target_b) = vvod1.split(" ").map { it.toInt() }        //Делим на Исходную и Таргет базы строку
            while (vvod2 != "/back") {                                                      //кольцо до /back
                print("Enter number in base $source_b to convert to base $target_b (To go back type /back) > ")
                vvod2 = readln()                                                            //Читаем число
                if (vvod2 != "/back") {                                                     //Проверка на /back
                    if (vvod2.lastIndexOf(".") == -1) {                               //Проверка на точку
                        println("Conversion result: " + vvod2.toBigInteger(source_b.toInt()).toString(target_b.toInt()))
                    } else {
                        val (i1, i2) = vvod2.split(".")                                //делим число на до точки и после точки
                        leftInt = i1
                        rightInt = i2
                        if (rightInt != "") {                                                   // Если после точки не пустое
                            if (rightInt == "0") {                                              //Если после точки равно 0
                                tempRightDec =
                                    "00000"                                          //Вывод за точкой равен 00000
                            } else {
                                for (i in 0..rightInt.length - 1) {             //Переводим дробную часть в 10 систему
                                    var tempInd10 =
                                        rightInt[i].toString().toBigInteger(source_b.toInt()).toString(10.toInt())
                                    tempInd10 = (tempInd10.toInt() * (source_b.toDouble().pow(-i - 1))).toString()
                                    drobIn10 = drobIn10.toDouble() + tempInd10.toDouble()
                                }
                                for (i in 0..4) {                               //Переводим дробную часть в конечную систему
                                    var tempInd17 = (drobIn10 * target_b).toString()
                                    val (l_x, r_x) = tempInd17.split(".")
                                    tempDrobTarget = l_x.toBigInteger(10.toInt()).toString(target_b.toInt())
                                    tempRightDec = tempRightDec.plus(tempDrobTarget)
                                    drobIn10 = ("0." + r_x).toDouble()
                                }
                            }
                        }
                        tempLeftDec = leftInt.toBigInteger(source_b.toInt()).toString(target_b.toInt())
                        println("Conversion result: " + tempLeftDec + "." + tempRightDec)
                        tempRightDec = ""
                        tempDrobTarget = ""
                        drobIn10 = 0.0
                    }
                } else {
                    vvod2 = ""
                    break
                }
            }
        } else break
    }
}
