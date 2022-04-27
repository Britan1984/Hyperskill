package converter

import java.math.BigInteger

fun main() {
    var komm1 = ""
    var komm2 = ""
    val text1 = "Conversion result: "
//    val text2 = "Conversion to decimal result: "
    var xTemp10 = BigInteger("0")
    while (komm1 != "/exit") {
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")

        komm1 = readln()
        if (komm1 != "/exit") {
            val (i1, i2) = komm1.split(" ").map { it.toInt() }


            while (komm2 != "/back") {
                print("Enter number in base $i1 to convert to base $i2 (To go back type /back) ")
                komm2 = readln()
                if (komm2 != "/back") {
                    val i3 = komm2.toBigInteger()
                    if (i1 != 10) {
                        when (i1) {
                            2 -> xTemp10 = BigInteger(i3.toString(), 2)
                            8 -> xTemp10 = BigInteger(i3.toString(), 8)
                            16 -> xTemp10 = BigInteger(i3.toString(), 16)
                        }
                    } else xTemp10 = i3
                } else {
                    komm2 = ""
                    break
                }
                when (i2) {
                    2 -> println(text1 + xTemp10.toString(2))
                    8 -> println(text1 + xTemp10.toString(8))
                    10 -> println(text1 + xTemp10)
                    16 -> println(text1 + xTemp10.toString(16))
                }
            }


//        if (komm1 == "/from") {
//            print("Enter number in decimal system: ")
//            val n = readLine()!!.toInt()
//            print("Enter target base: ")
//            val x = readLine()!!.toInt()
//            when (x) {
//                2 -> println(text1 + Integer.toBinaryString(n))
//                8 -> println(text1 + Integer.toOctalString(n))
//                16 -> println(text1 + Integer.toHexString(n))
//            }
//        } else if (komm1 == "/to") {
//            print("Enter source number: ")
//            val n = readln()
//            print("Enter source base: ")
//            val x = readLine()!!.toInt()
//            when (x) {
//                2 -> println(text2 + Integer.parseInt(n.toString(), 2))
//                8 -> println(text2 + Integer.parseInt(n.toString(), 8))
//                16 -> println(text2 + Integer.parseInt(n, 16))
//            }
//        }
        }
    }
}
