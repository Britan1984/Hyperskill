package machine

fun main() {
    print("Write how many cups of coffee you will need: ")
    val cupsCoffee = readln().toInt()
    println("""For $cupsCoffee cups of coffee you will need:
${cupsCoffee * 200} ml of water
${cupsCoffee * 50} ml of milk
${cupsCoffee * 15} g of coffee beans
    """.trimMargin())
}
