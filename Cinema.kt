package cinema

fun printCinema(row: Int, seat: Int, list: MutableList<Array<String>>) {
    var num = 0
    print(" ")
    repeat(seat) {
        print(" ${++num}")
    }
    println()
    num = 0
    for (i in 0..row-1) {
        print(++num)
        for (j in 0..seat-1){
            print(" ${list[i][j]}")
        }
        println()
    }
}
fun print(row: Int,seat: Int, list: MutableList<Array<String>>) {
    println()
    println("Cinema:")
    printCinema(row, seat, list)
    menu(row, seat, list)
}
fun menu(row: Int, seat: Int, list: MutableList<Array<String>>) {
    println()
    println("1. Show the seats")
    println("2. Buy a ticket")
    println("0. Exit")
    val x = readln().toInt()
    when (x) {
        1 -> print(row, seat, list)
        2 -> buy(row, seat, list)
        0 -> return
    }
}
fun buy(row: Int, seat: Int, list: MutableList<Array<String>>) {
    var halfRow = 0
    var ticketPrice = 0
    println()
    println("Enter a row number:")
    var rowNumber = readln().toInt()
    println("Enter a seat number in that row:")
    var seatNumber = readln().toInt()
    if (row * seat > 60) {
        halfRow = row / 2
        if (rowNumber > halfRow) {
            ticketPrice = 8
        } else ticketPrice = 10
    }else {
        ticketPrice = 10
    }
    println()
    println("Ticket price: $$ticketPrice")
    list[rowNumber - 1][seatNumber - 1] = "B"
    menu(row, seat, list)
}

fun main() {
    println("Enter the number of rows:")
    val row = readln().toInt()
    println("Enter the number of seats in each row:")
    val seat = readln().toInt()
    var list = mutableListOf<Array<String>>()
    for (i in 0..row) {
        var list2 = arrayOf<String>()
        for (j in 0..seat) {
            list2 += "S"
        }
        list += list2
    }
//    print(row, seat, list)
//    println()
    menu(seat, seat, list)
    println()
//    buy(seat, seat, list)
//    println()
//    print(seat, seat, list)
}
