package machine

import kotlin.math.ceil
import kotlin.math.min

var cupsCoffee = 0
var water = 0
var coffee = 0
var milk = 0
var coffeeCupsExitTemp = 0

fun enterComponents() {
    print("Write how many ml of water the coffee machine has: ")
    water = readln().toInt()
    println("")
    print("Write how many ml of milk the coffee machine has: ")
    milk = readln().toInt()
    println("")
    print("Write how many grams of coffee beans the coffee machine has: ")
    coffee = readln().toInt()
    println("")
    print("Write how many cups of coffee you will need: ")
    cupsCoffee = readln().toInt()
    println("")
}

fun coffeeCupsExit() {
    val cupsIfWater = ceil(water / 200.toDouble()).toInt()
    val cupsIfMilk = ceil(milk / 50.toDouble()).toInt()
    val cupsIfCofee = ceil(coffee / 15.toDouble()).toInt()
    coffeeCupsExitTemp = min(min(cupsIfWater, cupsIfMilk), cupsIfCofee)
    print()
}

fun print() {
    if ()
}

fun main() {
    enterComponents()
    println("""For $cupsCoffee cups of coffee you will need:
${cupsCoffee * 200} ml of water
${cupsCoffee * 50} ml of milk
${cupsCoffee * 15} g of coffee beans
    """.trimMargin())
}
