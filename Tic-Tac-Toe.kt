package tictactoe

//
//    for (i in 0..listWins.lastIndex) {
//        if (listWins[i] == true) {
//            lineWin ++
//            when(i) {
//                0 -> if (listCells[0] == "X") {
//                    xWin ++
//                } else
//                    if (listCells[0] == "O") {
//                        oWin ++
//                    }
//                1 -> if (listCells[3] == "X") {
//                    xWin ++
//                } else
//                    if (listCells[3] == "O") {
//                        oWin ++
//                    }
//                2 -> if (listCells[6] == "X") {
//                    xWin ++
//                } else
//                    if (listCells[6] == "O") {
//                        oWin ++
//                    }
//                3 -> if (listCells[0] == "X") {
//                    xWin ++
//                } else
//                    if (listCells[0] == "O") {
//                        oWin ++
//                    }
//                4 -> if (listCells[1] == "X") {
//                    xWin ++
//                } else
//                    if (listCells[1] == "O") {
//                        oWin ++
//                    }
//                5 -> if (listCells[2] == "X") {
//                    xWin ++
//                } else
//                    if (listCells[2] == "O") {
//                        oWin ++
//                    }
//                6 -> if (listCells[0] == "X") {
//                    xWin ++
//                } else
//                    if (listCells[0] == "O") {
//                        oWin ++
//                    }
//                7 -> if (listCells[2] == "X") {
//                    xWin ++
//                } else
//                    if (listCells[2] == "O") {
//                        oWin ++
//                    }
//            }
//        }
//    }
//    if (xPoint > oPoint + 1 || oPoint > xPoint + 1) {
//        println("Impossible")
//        return
//    }
//    for (i in 0..listCells.lastIndex) {
//        if (listCells[i].equals("_") && xWin == 0 && listCells[i].equals("_") && oWin == 0) {
//            println("Game not finished")
//            return
//        }
//    }
//    if (lineWin > 1) {
//        println("Impossible")
//        return
//    } else
//        if (xWin > 0) {
//            println("X wins")
//            return
//        } else
//            if (oWin > 0) {
//                println("O wins")
//                return
//            } else
//                if (xWin == 0 && oWin == 0) {
//                    println("Draw")
//                    return
//                }
//}

fun printer(list1: MutableList<Char>, list2: MutableList<Char>, list3: MutableList<Char>){
    println("---------")
    println("| ${list1[0]} ${list1[1]} ${list1[2]} |")
    println("| ${list2[0]} ${list2[1]} ${list2[2]} |")
    println("| ${list3[0]} ${list3[1]} ${list3[2]} |")
    println("---------")
}

fun xWins(list1: MutableList<Char>, list2: MutableList<Char>, list3: MutableList<Char>):Int {
    var xWin = 0
    when {
        list1[0].toString() + list1[1] + list1[2] == "XXX" ->xWin = 1
        list2[0].toString() + list2[1] + list2[2] == "XXX" ->xWin = 1
        list3[0].toString() + list3[1] + list3[2] == "XXX" ->xWin = 1
        list1[0].toString() + list2[0] + list3[0] == "XXX" ->xWin = 1
        list1[1].toString() + list2[1] + list3[1] == "XXX" ->xWin = 1
        list1[2].toString() + list2[2] + list3[2] == "XXX" ->xWin = 1
        list1[0].toString() + list2[1] + list3[2] == "XXX" ->xWin = 1
        list1[2].toString() + list2[1] + list3[0] == "XXX" ->xWin = 1
    }
    return xWin
}

fun oWins(list1: MutableList<Char>, list2: MutableList<Char>, list3: MutableList<Char>):Int {
    var oWin = 0
    when {
        list1[0].toString() + list1[1] + list1[2] == "OOO" ->oWin = 1
        list2[0].toString() + list2[1] + list2[2] == "OOO" ->oWin = 1
        list3[0].toString() + list3[1] + list3[2] == "OOO" ->oWin = 1
        list1[0].toString() + list2[0] + list3[0] == "OOO" ->oWin = 1
        list1[1].toString() + list2[1] + list3[1] == "OOO" ->oWin = 1
        list1[2].toString() + list2[2] + list3[2] == "OOO" ->oWin = 1
        list1[0].toString() + list2[1] + list3[2] == "OOO" ->oWin = 1
        list1[2].toString() + list2[1] + list3[0] == "OOO" ->oWin = 1
    }
    return oWin
}

fun proverka(list1: MutableList<Char>, list2: MutableList<Char>, list3: MutableList<Char>):String {
    val x = xWins(list1, list2, list3)
    val o = oWins(list1, list2, list3)
    if (x > 0 && o > 0) {
        println("Draw")
        return "STOP"
    } else
        if (x > 0) {
            println("X wins")
            return "STOP"
        } else
            if (o > 0) {
                println("O wins")
                return "STOP"
            }
    return ""
}

fun main() {

    print("Enter cells: ")
    val enterCells = readln()
    var xPoint = 0
    var oPoint = 0
    var lineWin = 0
    var xWin = 0
    var oWin = 0
    for (i in enterCells) {
        if (i == 'X') ++xPoint
        if (i == 'O') ++oPoint
    }
    val list1 = mutableListOf(enterCells[0], enterCells[1], enterCells[2])  //первая строка
    val list2 = mutableListOf(enterCells[3], enterCells[4], enterCells[5])  //вторая строка
    val list3 = mutableListOf(enterCells[6], enterCells[7], enterCells[8])  //третья строка
    printer(list1, list2, list3) //печатаем сетку
    while (true) {
//        if (proverka(list1, list2, list3) == "STOP") {
//            break
//        }
        print("Enter the coordinates: ")
        val (x1, y1) = readln().split(" ")  //координаты добавляемого Х
        try {
            if (x1.toInt() >= 1 && x1.toInt() <= 3 && y1.toInt() >= 1 && y1.toInt() <= 3) { //проверка на числа от 1 до 3
                var tempCell: Char  //значение в ячейке в которое планируем вносить Х
                if (x1.toInt() == 1) {
                    tempCell = list1[y1.toInt() - 1]    //значение из первой строки если первое число = 1
                } else
                    if (x1.toInt() == 2) {  //значение из второй строки если первое число = 2
                        tempCell = list2[y1.toInt() - 1]
                    } else tempCell = list3[y1.toInt() - 1] //значение из третьей строки если первое число = 3
                if (tempCell != '_') {  //если число в строке не пусто
                    println("This cell is occupied! Choose another one!")
                } else
                    if (x1.toInt() == 1) {  //если пусто и первое число = 1 подставляем на пустое место Х
                        list1.removeAt(y1.toInt()-1)
                        list1.add(y1.toInt()-1, 'X')
                        printer(list1, list2, list3)
                        break
//                        if (proverka(list1, list2, list3) == "STOP") {
//                            break
//                        }
                    } else
                        if (x1.toInt() == 2) {  //если пусто и первое число = 2 подставляем на пустое место Х
                            list2.removeAt(y1.toInt()-1)
                            list2.add(y1.toInt()-1, 'X')
                            printer(list1, list2, list3)
                            break
//                            if (proverka(list1, list2, list3) == "STOP") {
//                                break
//                            }
                        } else {    //если пусто и первое число = 3 подставляем на пустое место Х
                            list3.removeAt(y1.toInt()-1)
                            list3.add(y1.toInt()-1, 'X')
                            printer(list1, list2, list3)
                            break
//                            if (proverka(list1, list2, list3) == "STOP") {
//                                break
//                            }
                        }
            }
            else println("Coordinates should be from 1 to 3!")
        } catch (e: NumberFormatException) {
            println("You should enter numbers!")
        }
    }
}
