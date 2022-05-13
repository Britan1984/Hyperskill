package tictactoe

fun main() {
    var listCells: MutableList<String> = mutableListOf()
    print("Enter cells: ")
    val enterCells = readln()
    var xPoint = 0
    var oPoint = 0
    var lineWin = 0
    var xWin = 0
    var oWin = 0
    for (i in 0..enterCells.lastIndex) {
        listCells.add(enterCells.get(i).toString())
        if (enterCells.get(i).equals('X')) {
            xPoint ++
        } else
            if (enterCells.get(i).equals('O')) {
                oPoint ++
            }
    }
    println("---------")
    println("| ${listCells[0]} ${listCells[1]} ${listCells[2]} |")
    println("| ${listCells[3]} ${listCells[4]} ${listCells[5]} |")
    println("| ${listCells[6]} ${listCells[7]} ${listCells[8]} |")
    println("---------")
    var listWins: MutableList<Boolean> = mutableListOf()
    listWins.add(listCells[0] == listCells[1] && listCells[0] == listCells[2])
    listWins.add(listCells[3] == listCells[4] && listCells[3] == listCells[5])
    listWins.add(listCells[6] == listCells[7] && listCells[6] == listCells[8])
    listWins.add(listCells[0] == listCells[3] && listCells[0] == listCells[6])
    listWins.add(listCells[1] == listCells[4] && listCells[1] == listCells[7])
    listWins.add(listCells[2] == listCells[5] && listCells[2] == listCells[8])
    listWins.add(listCells[0] == listCells[4] && listCells[0] == listCells[8])
    listWins.add(listCells[2] == listCells[4] && listCells[2] == listCells[6])

    for (i in 0..listWins.lastIndex) {
        if (listWins[i] == true) {
            lineWin ++
            when(i) {
                0 -> if (listCells[0] == "X") {
                    xWin ++
                } else
                    if (listCells[0] == "O") {
                        oWin ++
                    }
                1 -> if (listCells[3] == "X") {
                    xWin ++
                } else
                    if (listCells[3] == "O") {
                        oWin ++
                    }
                2 -> if (listCells[6] == "X") {
                    xWin ++
                } else
                    if (listCells[6] == "O") {
                        oWin ++
                    }
                3 -> if (listCells[0] == "X") {
                    xWin ++
                } else
                    if (listCells[0] == "O") {
                        oWin ++
                    }
                4 -> if (listCells[1] == "X") {
                    xWin ++
                } else
                    if (listCells[1] == "O") {
                        oWin ++
                    }
                5 -> if (listCells[2] == "X") {
                    xWin ++
                } else
                    if (listCells[2] == "O") {
                        oWin ++
                    }
                6 -> if (listCells[0] == "X") {
                    xWin ++
                } else
                    if (listCells[0] == "O") {
                        oWin ++
                    }
                7 -> if (listCells[2] == "X") {
                    xWin ++
                } else
                    if (listCells[2] == "O") {
                        oWin ++
                    }
            }
        }
    }
    if (xPoint > oPoint + 1 || oPoint > xPoint + 1) {
        println("Impossible")
        return
    }
    for (i in 0..listCells.lastIndex) {
        if (listCells[i].equals("_") && xWin == 0 && listCells[i].equals("_") && oWin == 0) {
            println("Game not finished")
            return
        }
    }
    if (lineWin > 1) {
        println("Impossible")
        return
    } else
        if (xWin > 0) {
            println("X wins")
            return
        } else
            if (oWin > 0) {
                println("O wins")
                return
            } else
                if (xWin == 0 && oWin == 0) {
                    println("Draw")
                    return
                }
}
