package tictactoe

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

fun pustMesto(list1: MutableList<Char>, list2: MutableList<Char>, list3: MutableList<Char>):Int {
    var p = 0
    for (i in list1) {
        if (i == ' ') {
            p = 1
        }
    }
    for (i in list2) {
        if (i == ' ') {
            p = 1
        }
    }
    for (i in list3) {
        if (i == ' ') {
            p = 1
        }
    }
    return p
}

fun proverka(list1: MutableList<Char>, list2: MutableList<Char>, list3: MutableList<Char>):String {
    val x = xWins(list1, list2, list3)
    val o = oWins(list1, list2, list3)
    val p = pustMesto(list1, list2, list3)
    val xop = x+o+p
    if (x > 0 && o > 0 || xop == 0) {
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

fun hodX(x1: String, y1: String, list1: MutableList<Char>, list2: MutableList<Char>, list3: MutableList<Char>):Boolean {
    if (x1.toInt() >= 1 && x1.toInt() <= 3 && y1.toInt() >= 1 && y1.toInt() <= 3) { //проверка на числа от 1 до 3
        val tempCell: Char  //значение в ячейке в которое планируем вносить Х
        if (x1.toInt() == 1) {
            tempCell = list1[y1.toInt() - 1]    //значение из первой строки если первое число = 1
        } else
            if (x1.toInt() == 2) {  //значение из второй строки если первое число = 2
                tempCell = list2[y1.toInt() - 1]
            } else tempCell = list3[y1.toInt() - 1] //значение из третьей строки если первое число = 3
        if (tempCell != ' ') {  //если число в строке не пусто
            println("This cell is occupied! Choose another one!")
        } else
            if (x1.toInt() == 1) {  //если пусто и первое число = 1 подставляем на пустое место Х
                list1.removeAt(y1.toInt()-1)
                list1.add(y1.toInt()-1, 'X')
                printer(list1, list2, list3)
                if (proverka(list1, list2, list3) == "STOP") {
                    System.exit(0)
                }
                return false
            } else
                if (x1.toInt() == 2) {  //если пусто и первое число = 2 подставляем на пустое место Х
                    list2.removeAt(y1.toInt()-1)
                    list2.add(y1.toInt()-1, 'X')
                    printer(list1, list2, list3)
                    if (proverka(list1, list2, list3) == "STOP") {
                        System.exit(0)
                    }
                    return false
                } else {    //если пусто и первое число = 3 подставляем на пустое место Х
                    list3.removeAt(y1.toInt()-1)
                    list3.add(y1.toInt()-1, 'X')
                    printer(list1, list2, list3)
                    if (proverka(list1, list2, list3) == "STOP") {
                        System.exit(0)
                    }
                    return false
                }
    }
    else println("Coordinates should be from 1 to 3!")
    return true
}

fun hodO(x2: String, y2: String, list1: MutableList<Char>, list2: MutableList<Char>, list3: MutableList<Char>):Boolean {
    if (x2.toInt() >= 1 && x2.toInt() <= 3 && y2.toInt() >= 1 && y2.toInt() <= 3) { //проверка на числа от 1 до 3
        val tempCell: Char  //значение в ячейке в которое планируем вносить O
        if (x2.toInt() == 1) {
            tempCell = list1[y2.toInt() - 1]    //значение из первой строки если первое число = 1
        } else
            if (x2.toInt() == 2) {  //значение из второй строки если первое число = 2
                tempCell = list2[y2.toInt() - 1]
            } else tempCell = list3[y2.toInt() - 1] //значение из третьей строки если первое число = 3
        if (tempCell != ' ') {  //если число в строке не пусто
            println("This cell is occupied! Choose another one!")
        } else
            if (x2.toInt() == 1) {  //если пусто и первое число = 1 подставляем на пустое место Х
                list1.removeAt(y2.toInt()-1)
                list1.add(y2.toInt()-1, 'O')
                printer(list1, list2, list3)
                if (proverka(list1, list2, list3) == "STOP") {
                    System.exit(0)
                }
                return false
            } else
                if (x2.toInt() == 2) {  //если пусто и первое число = 2 подставляем на пустое место Х
                    list2.removeAt(y2.toInt()-1)
                    list2.add(y2.toInt()-1, 'O')
                    printer(list1, list2, list3)
                    if (proverka(list1, list2, list3) == "STOP") {
                        System.exit(0)
                    }
                    return false
                } else {    //если пусто и первое число = 3 подставляем на пустое место Х
                    list3.removeAt(y2.toInt()-1)
                    list3.add(y2.toInt()-1, 'O')
                    printer(list1, list2, list3)
                    if (proverka(list1, list2, list3) == "STOP") {
                        System.exit(0)
                    }
                    return false
                }
    }
    else println("Coordinates should be from 1 to 3!")
    return true
}

fun main() {
    val list1 = mutableListOf(' ', ' ', ' ')  //первая строка
    val list2 = mutableListOf(' ', ' ', ' ')  //вторая строка
    val list3 = mutableListOf(' ', ' ', ' ')  //третья строка
    printer(list1, list2, list3) //печатаем сетку
    while (true) {
        while (true) {
            try {
                print("Enter the coordinates: ")
                val (x1, y1) = readln().split(" ")  //координаты добавляемого Х
                if (hodX(x1, y1, list1, list2, list3) == false) {
                    break
                }
            } catch (e: NumberFormatException) {
                println("You should enter numbers!")
            }
        }
        while (true) {
            try {
                print("Enter the coordinates: ")
                val (x2, y2) = readln().split(" ")  //координаты добавляемого O
                if (hodO(x2, y2, list1, list2, list3) == false) {
                    break
                }
            } catch (e: NumberFormatException) {
                println("You should enter numbers!")
            }
        }
    }
}
