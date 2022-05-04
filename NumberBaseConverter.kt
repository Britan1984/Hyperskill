package converter

import java.math.BigInteger

fun main() {
    var komm1 = ""
    var komm2 = ""
    val text1 = "Conversion result: "
    var xTemp10 = BigInteger("0")
    var xTemp = 0
    while (komm1 != "/exit") {
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
        komm1 = readln()
        if (komm1 != "/exit") {
            val (i1, i2) = komm1.split(" ").map { it.toInt() }
            while (komm2 != "/back") {
                print("Enter number in base $i1 to convert to base $i2 (To go back type /back) ")
                komm2 = readln()
                if (komm2 != "/back") {
                    println(text1 + komm2.toBigInteger(i1.toInt()).toString(i2.toInt()))
                } else {
                    komm2 = ""
                    break
                }
            }
        }
    }
}
