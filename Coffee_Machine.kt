package machine

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.min

var cupsCoffee = 0
var water = 0
var coffee = 0
var milk = 0
var coffeeCupsExitTemp = 0

fun enterComponents() {
    print("Write how many ml of water the coffee machine has: ")
    water = readln().toInt()
    print("Write how many ml of milk the coffee machine has: ")
    milk = readln().toInt()
    print("Write how many grams of coffee beans the coffee machine has: ")
    coffee = readln().toInt()
    print("Write how many cups of coffee you will need: ")
    cupsCoffee = readln().toInt()
}

fun coffeeCupsExit() {
    val cupsIfWater = floor(water / 200.toDouble()).toInt()
    val cupsIfMilk = floor(milk / 50.toDouble()).toInt()
    val cupsIfCofee = floor(coffee / 15.toDouble()).toInt()
    coffeeCupsExitTemp = min(min(cupsIfWater, cupsIfMilk), cupsIfCofee)
    print()
}

fun print() {
    if (cupsCoffee == coffeeCupsExitTemp) {
        println("Yes, I can make that amount of coffee")
    } else
        if (cupsCoffee < coffeeCupsExitTemp) {
            println("Yes, I can make that amount of coffee (and even ${coffeeCupsExitTemp - cupsCoffee} more than that)")
        } else println("No, I can make only $coffeeCupsExitTemp cups of coffee")
}

fun main() {
    enterComponents()
    coffeeCupsExit()
//    println("""For $cupsCoffee cups of coffee you will need:
//${cupsCoffee * 200} ml of water
//${cupsCoffee * 50} ml of milk
//${cupsCoffee * 15} g of coffee beans
//    """.trimMargin())
}
