package cinema

var row = 0
var seat = 0
var seatZanyato = 0
var seatAll = 0
var curIncome = 0
var totIncome = 0
var halfRow = 0
var ticketPrice = 0
val list = mutableListOf<Array<String>>()
fun printCinema() {
    var num = 0
    print(" ")
    repeat(seat) {
        print(" ${++num}")
    }
    println()
    num = 0
    for (i in 0..row - 1) {
        print(++num)
        for (j in 0..seat - 1) {
            print(" ${list[i][j]}")
        }
        println()
    }
}
fun print() {
    println()
    println("Cinema:")
    printCinema()
    menu()
}
fun printStat() {
    val percentage =  100 / seatAll.toDouble() * seatZanyato
    val formatPercentage = "%.2f".format(percentage)
    println("Number of purchased tickets: $seatZanyato")
    println("Percentage: $formatPercentage%")
    println("Current income: $$curIncome")
    println("Total income: $$totIncome")
}
fun menu() {
    println()
    println("1. Show the seats")
    println("2. Buy a ticket")
    println("3. Statistics")
    println("0. Exit")
    val x = readln().toInt()
    when (x) {
        1 -> print()
        2 -> buy()
        3 -> statistic()
        0 -> return
    }
}
fun buy() {
    while (true) {
        println()
        println("Enter a row number:")
        val rowNumber = readln().toInt()
        println("Enter a seat number in that row:")
        val seatNumber = readln().toInt()
        if (rowNumber <= row && seatNumber <= seat) {
            if (list[rowNumber - 1][seatNumber - 1].equals("S")) {
                if (row * seat > 60) {
                    halfRow = row / 2
                    if (rowNumber > halfRow) {
                        ticketPrice = 8
                    } else ticketPrice = 10
                } else {
                    ticketPrice = 10
                }
                println()
                println("Ticket price: $$ticketPrice")
                list[rowNumber - 1][seatNumber - 1] = "B"
                ++seatZanyato
                curIncome += ticketPrice
                menu()
            } else {
                println()
                println("That ticket has already been purchased!")
            }
        } else {
            println()
            println("Wrong input!")
        }
    }
}
fun statistic() {
    totIncome()
    printStat()
    menu()
}
fun totIncome() {
    if (row * seat > 60) {
        halfRow = row / 2
        totIncome = halfRow * seat * 10 + (row - halfRow) * seat * 8
    } else {
        totIncome = seatAll * 10
    }
}
fun main() {
    println("Enter the number of rows:")
    row = readln().toInt()
    println("Enter the number of seats in each row:")
    seat = readln().toInt()
    seatAll = row * seat
    for (i in 0..row) {
        var list2 = arrayOf<String>()
        for (j in 0..seat) {
            list2 += "S"
        }
        list += list2
    }
    menu()
    println()
}
