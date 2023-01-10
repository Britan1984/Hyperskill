package chess

import java.io.Serializable
import kotlin.system.exitProcess

fun name():Pair<String,String>{
    print("First Player's name: ")
    val name1 = readln()
    print("Second Player's name: ")
    val name2 = readln()
    return Pair(name1,name2)
}

fun win(w:String){
    when(w){
        "W" -> println("White Wins!")
        "B" -> println("Black Wins!")
        else -> println("Stalemate!")
    }
    exit()
}

fun exit(){
    println("Bye!")
    exitProcess(0)
}


fun walk(name1:String, name2:String) {
    var walkPlayer = ""
    var wPlayer: CharArray
    var checkPole: String
    val poleB = "[a-h]".toRegex()
    val poleN = "[1-8]".toRegex()
    val pole = arrayListOf(
        charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
        charArrayOf('W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'),
        charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
        charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
        charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
        charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
        charArrayOf('B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'),
        charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ')
    )
    var (n1, l1, l2, N1, N2) = List(5) { 0 }
    var L1 = 0
    var (number1, number2) = List(2) { ' ' }
    fun vvod(s: String) {
        var z = 0
        println()
        if (n1 % 2 == 0) {
            println("$name1's turn:")
        } else (println("$name2's turn:"))
        walkPlayer = readln()

//Если Exit то закрываем программу
        if (walkPlayer == "exit") {
            exit()
        }

        wPlayer = walkPlayer.toCharArray()
        when (wPlayer[0]) {
            'a' -> l1 = 0
            'b' -> l1 = 1
            'c' -> l1 = 2
            'd' -> l1 = 3
            'e' -> l1 = 4
            'f' -> l1 = 5
            'g' -> l1 = 6
            'h' -> l1 = 7
            else -> l1 = 666
        }
        when (wPlayer[2]) {
            'a' -> l2 = 0
            'b' -> l2 = 1
            'c' -> l2 = 2
            'd' -> l2 = 3
            'e' -> l2 = 4
            'f' -> l2 = 5
            'g' -> l2 = 6
            'h' -> l2 = 7
            else -> l2 = 666
        }
        number1 = wPlayer[1]
        number2 = wPlayer[3]
        checkPole = pole[number1.digitToInt() - 1][l1].toString()

//Если указано больше 4 символов то Invalid Input
        if (walkPlayer.length > 4) {
            println("Invalid Input")
            vvod(s)
        }

//Если указано за границей поля то Invalid Input
        for (i in wPlayer) {

            if (z % 2 == 0) {
                if (i.toString().matches(poleB)) {
                    z++
                } else {
                    println("Invalid Input")
                    vvod(s)
                }
            } else {
                if (i.toString().matches(poleN)) {
                    z++
                } else {
                    println("Invalid Input")
                    vvod(s)
                }
            }
        }

//Если на начальной позиции нет фигуры белого цвета
        if (s == "W" && checkPole != "W") {             //Если на начальной позиции нет фигуры белого цвета то No white pawn at
            println("No white pawn at ${wPlayer[0]}${wPlayer[1]}")
            vvod(s)
        }

//Если на начальной позиции нет фигуры черного цвета
        if (s == "B" && checkPole != "B") {
            println("No black pawn at ${wPlayer[0]}${wPlayer[1]}")
            vvod(s)
        }

//Проверка следующей клетки
        if (s == "W") {
            if (l1 == l2 && pole[number2.digitToInt() - 1][l2].toString() == "B") {
                println("Invalid Input")
                vvod(s)
            }
        } else {
            if (l1 == l2 && pole[number2.digitToInt() - 1][l2].toString() == "W") {
                println("Invalid Input")
                vvod(s)
            }
        }

//Проверка хода в сторону
        if (number1.digitToInt() == number2.digitToInt()) {
            println("Invalid Input")
            vvod(s)
        }

//Запрет на ход назад
        if (s == "W") {
            if (number2.digitToInt() < number1.digitToInt()) {
                println("Invalid Input")
                vvod(s)
            }
        } else {
            if (number2.digitToInt() > number1.digitToInt()) {
                println("Invalid Input")
                vvod(s)
            }
        }

//Съедание в проходе
        if ((N1 == 2 || N1 == 7) && L1 == l2) {
            if (s == "W") {
                if (N1 == 7 && (number2.digitToInt() == N2+1 && (l2 - 1 == l1 || l2 + 1 == l1))) {
                    pole[number2.digitToInt() - 1][l2] = 'W'
                    pole[number2.digitToInt() - 2][l2] = ' '
                    return
                }
            } else {
                if (N1 == 2 && (number2.digitToInt() == N2-1 && (l2 - 1 == l1 || l2 + 1 == l1))) {
                    pole[number2.digitToInt() - 1][l2] = 'B'
                    pole[number2.digitToInt() - 2][l2] = ' '
                    return
                }
            }
        }

//Сьедаем по диагонали
//для белых
        if (s == "W") {
            if ((l1 + 1 == l2 || l1 - 1 == l2) && pole[number2.digitToInt() - 1][l2] == 'B' && number1.digitToInt() + 1 == number2.digitToInt()) {
                pole[number2.digitToInt() - 1][l2] = 'W'
                pole[number1.digitToInt() - 1][l1] = ' '
            } else {
                if (number1.digitToInt() == 2 && number2.digitToInt() - number1.digitToInt() > 2) {
                    println("Invalid Input")
                    vvod(s)
                }
                if (number1.digitToInt() != 2 && number2.digitToInt() - number1.digitToInt() > 1) {
                    println("Invalid Input")
                    vvod(s)
                }
                if (l1 != l2) {
                    println("Invalid Input")
                    vvod(s)
                }
            }
        }
//для черных
        else {
            if ((l2 + 1 == l1 || l2 - 1 == l1) && pole[number2.digitToInt() - 1][l2] == 'W' && number1.digitToInt() - 1 == number2.digitToInt()) {
                pole[number2.digitToInt() - 1][l2] = 'B'
                pole[number1.digitToInt() - 1][l1] = ' '
            } else {
                if (number1.digitToInt() == 7 && number1.digitToInt() - number2.digitToInt() > 2) {
                    println("Invalid Input")
                    vvod(s)
                }
                if (number1.digitToInt() != 7 && number1.digitToInt() - number2.digitToInt() > 1) {
                    println("Invalid Input")
                    vvod(s)
                }
                if (l1 != l2) {
                    println("Invalid Input")
                    vvod(s)
                }
            }
        }
    }
    fun pole(col: Char = ' ') {
        val q = pole[number1.digitToInt() - 1][l1]
        if (col == q) {
            pole[number1.digitToInt() - 1][l1] = ' '
            pole[number2.digitToInt() - 1][l2] = col
        }
    }

    fun polePrint() {
        var ryad = 8
        println("  +---+---+---+---+---+---+---+---+")
        for (i in pole.asReversed()) {
            print("$ryad |")
            print("")
            for (j in i) {
                print(" $j |")
            }
            println()
            println("  +---+---+---+---+---+---+---+---+")
            ryad--
        }
        println("    a   b   c   d   e   f   g   h  ")
    }
    polePrint()
    fun pusto(z: Char){
        var x = 0
        for (i in pole){
            if (i.contains(z)){
                x++
            }
        }
        if (x==0) {
            if(z=='W') win("B") else win("W")
        }
    }
    fun stalemate(c:Char){
        var zW = 0
        var zB = 0
        if (c=='W') {
            for (i in pole.indices) {
                if (pole[i].contains('W')) {
                    for (j in pole[i].indices) {
                        if (pole[i][j] == 'W') {
                            if (j < 7) {
                                if (pole[i + 1][j] == ' ' || pole[i + 1][j + 1] == 'B') {
                                    zW = 0; break
                                } else zW = 1
                            } else {
                                if (pole[i + 1][j] == ' ' || pole[i + 1][j - 1] == 'B') {
                                    zW = 0; break
                                } else zW = 1
                            }
                        }
                    }
                    if (zW == 1) win("stalement") else break
                }
            }
        }
        if (c == 'B') {
            for (i in pole.indices) {
                if (pole[i].contains('B')) {
                    for (j in pole[i].indices) {
                        if (pole[i][j] == 'B') {
                            if (j < 7) {
                                if (pole[i - 1][j] == ' ' || pole[i - 1][j + 1] == 'W') {
                                    zB = 0; break
                                } else zB = 1
                            } else {
                                if (pole[i - 1][j] == ' ' || pole[i + 1][j - 1] == 'B') {
                                    zB = 0; break
                                } else zB = 1
                            }
                        }
                    }
                    if (zB == 1) win("stalement") else break
                }
            }
        }
    } //проверка на ничью
    while (walkPlayer != "exit") {
        if (n1 % 2 == 0) {
            stalemate('W') //проверка на ничью
            vvod("W")
            n1++
            pole('W')
            polePrint()
            if (number2=='8') win("W")
            pusto('B')
        } else {
            stalemate('B') //проверка на ничью
            vvod("B")
            n1++
            pole('B')
            polePrint()
            if (number2=='1') win("B")
            pusto('W')
        }
        N1 = number1.digitToInt() //
        N2 = number2.digitToInt()
        L1 = l1
    }
}

fun main() {
    println("Pawns-Only Chess")
    val (name1,name2) = name()
    println()
    walk(name1, name2)
}
