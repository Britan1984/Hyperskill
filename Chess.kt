package chess

fun name():Pair<String,String>{
    print("First Player's name: ")
    val name1 = readln().toString()
    print("Second Player's name: ")
    val name2 = readln().toString()
    return Pair(name1,name2)
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
    var (n1, l1, l2, K, L) = List(5) { 0 }
    var (number1, number2) = List(2) { ' ' }
    fun vvod(s: String) {
        var z = 0
        println()
        if (n1 % 2 == 0) {
            println("$name1's turn:")
        } else (println("$name2's turn:"))
        walkPlayer = readln().toString()

//Если Exit то закрываем программу
        if (walkPlayer.equals("exit")) {
            println("Bye!")
            System.exit(0)
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
        if (s.equals("W") && !checkPole.equals("W")) {             //Если на начальной позиции нет фигуры белого цвета то No white pawn at
            println("No white pawn at ${wPlayer[0]}${wPlayer[1]}")
            vvod(s)
        }

//Если на начальной позиции нет фигуры черного цвета
        if (s.equals("B") && !checkPole.equals("B")) {
            println("No black pawn at ${wPlayer[0]}${wPlayer[1]}")
            vvod(s)
        }

//Проверка следующей клетки
        if (s.equals("W")) {
            if (l1 == l2 && pole[number2.digitToInt() - 1][l2].toString().equals("B")) {
                println("Invalid Input")
                vvod(s)
            }
        } else {
            if (l1 == l2 && pole[number2.digitToInt() - 1][l2].toString().equals("W")) {
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
        if (s.equals("W")) {
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
        if (L == 2 || L == 7) {
            if (s.equals("W")) {
                if (L == 7 && (l2 == K && (l2 - 1 == l1 || l2 + 1 == l1))) {
                    pole[number2.digitToInt() - 1][l2] = 'W'
                    pole[number2.digitToInt() - 2][l2] = ' '
                    return
                }
            } else {
                if (L == 2 && (l2 == K && (l2 - 1 == l1 || l2 + 1 == l1))) {
                    pole[number2.digitToInt() + 1][l2] = 'B'
                    pole[number2.digitToInt() + 2][l2] = ' '
                    return
                }
            }
        }

//Проверка пустой диагонали
//        if (s.equals("W")) {
//            if ((l2 - 1 == l1 || l2 + 1 == l1) && number2.digitToInt() + 1 == number1.digitToInt() && !pole[number2.digitToInt() + 1][l2].equals(
//                    'B'
//                )
//            ) {
//                println("Invalid Input")
//                vvod(s)
//            }
//        } else {
//            if ((l2 - 1 == l1 || l2 + 1 == l1) && number2.digitToInt() + 1 == number1.digitToInt() && !pole[number2.digitToInt() + 1][l2].equals(
//                    'W'
//                )
//            ) {
//                println("Invalid Input")
//                vvod(s)
//            }
//        }

//Сьедаем по диагонали
//для белых
        if (s.equals("W")) {
            if ((l1 + 1 == l2 || l1 - 1 == l2) && pole[number2.digitToInt() - 1][l2].equals('B') && number1.digitToInt() + 1 == number2.digitToInt()) {
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
            if ((l2 + 1 == l1 || l2 - 1 == l1) && pole[number2.digitToInt() - 1][l2].equals('W') && number1.digitToInt() - 1 == number2.digitToInt()) {
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
            if (col.equals(q)) {
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
        while (!walkPlayer.equals("exit")) {
            if (n1 % 2 == 0) {
                vvod("W")
                n1++
                pole('W')
                polePrint()
            } else {
                vvod("B")
                n1++
                pole('B')
                polePrint()
            }
            L = number1.digitToInt() //
            K = l1
        }
    }

fun main() {
    println("Pawns-Only Chess")
    val (name1,name2) = name()
    println()
    walk(name1, name2)
}
