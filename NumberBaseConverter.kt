package converter

fun main() {
    var komm1 = ""
    val text1 = "Conversion result: "
    val text2 = "Conversion to decimal result: "
    while (komm1 != "/exit") {
        print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ")
        komm1 = readln()
        if (komm1 == "/from") {
            print("Enter number in decimal system: ")
            val n = readLine()!!.toInt()
            print("Enter target base: ")
            val x = readLine()!!.toInt()
            when (x) {
                2 -> println(text1 + Integer.toBinaryString(n))
                8 -> println(text1 + Integer.toOctalString(n))
                16 -> println(text1 + Integer.toHexString(n))
            }
        } else if (komm1 == "/to") {
            print("Enter source number: ")
            val n = readln()
            print("Enter source base: ")
            val x = readLine()!!.toInt()
            when (x) {
                2 -> println(text2 + Integer.parseInt(n.toString(), 2))
                8 -> println(text2 + Integer.parseInt(n.toString(), 8))
                16 -> println(text2 + Integer.parseInt(n, 16))
            }
        }
    }
}
