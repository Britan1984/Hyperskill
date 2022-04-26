package converter

fun main() {
    var komm1 = ""
    while (komm1 != "/exit") {
        print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ")
        komm1 = readln()
        if (komm1 == "/from") {
            print("Enter number in decimal system: ")
            val n = readLine()!!.toInt()
            print("Enter target base: ")
            val x = readLine()!!.toInt()
            when (x) {
                2 -> println("Conversion result: " + Integer.toBinaryString(n))
                8 -> println("Conversion result: " + Integer.toOctalString(n))
                16 -> println("Conversion result: " + Integer.toHexString(n))
            }
        } else if (komm1 == "/to") {
            print("Enter source number: ")
            val n = readln()
            print("Enter source base: ")
            val x = readLine()!!.toInt()
            when (x) {
                2 -> println("Conversion to decimal result: " + Integer.parseInt(n.toString(), 2))
                8 -> println("Conversion to decimal result: " + Integer.parseInt(n.toString(), 8))
                16 -> println("Conversion to decimal result: " + Integer.parseInt(n, 16))
            }
        }
    }
}
