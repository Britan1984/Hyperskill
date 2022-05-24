package machine

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.min

var cupsCoffee = 0
var water = 400
var coffee = 120
var milk = 540
var cups = 9
var money = 550
var coffeeCupsExitTemp = 0

fun enterComponents() {
    print("Write how many ml of water do you want to add: ")
    water += readln().toInt()
    print("Write how many ml of milk do you want to add: ")
    milk += readln().toInt()
    print("Write how many grams of coffee beans do you want to add: ")
    coffee += readln().toInt()
    print("Write how many disposable cups of coffee do you want to add: ")
    cups += readln().toInt()
}

fun coffeeCupsExit() {
    val cupsIfWater = floor(water / 200.toDouble()).toInt()
    val cupsIfMilk = floor(milk / 50.toDouble()).toInt()
    val cupsIfCofee = floor(coffee / 15.toDouble()).toInt()
    coffeeCupsExitTemp = min(min(cupsIfWater, cupsIfMilk), cupsIfCofee)
    printComponents()
}

fun printComponents() {
//    if (cupsCoffee == coffeeCupsExitTemp) {
//        println("Yes, I can make that amount of coffee")
//    } else
//        if (cupsCoffee < coffeeCupsExitTemp) {
//            println("Yes, I can make that amount of coffee (and even ${coffeeCupsExitTemp - cupsCoffee} more than that)")
//        } else println("No, I can make only $coffeeCupsExitTemp cups of coffee")
    println("""The coffee machine has:
$water ml of water
$milk ml of milk
$coffee g of coffee beans
$cups disposable cups
$$money of money""")
    println()
}

fun espresso() {
    if (water < 250) {
        println("Sorry, not enough water!")
        return
    } else
        if (coffee < 16) {
            println("Sorry, not enough coffee!")
            return
        } else
            if (cups < 1) {
                println("Sorry, not enough disposable cups!")
                return
            }
    water -= 250
    coffee -= 16
    cups --
    money += 4
    println("I have enough resources, making you a coffee!")
}

fun latte() {
    if (water < 350) {
        println("Sorry, not enough water!")
        return
    } else
        if (coffee < 20) {
            println("Sorry, not enough coffee!")
            return
        } else
            if (milk < 75) {
                println("Sorry, not enough milk!")
                return
            } else
                if (cups < 1) {
                    println("Sorry, not enough disposable cups!")
                    return
                }
    coffee -= 20
    water -= 350
    milk -= 75
    cups --
    money += 7
    println("I have enough resources, making you a coffee!")
}

fun cappuccino() {

    if (water < 200) {
        println("Sorry, not enough water!")
        return
    } else
        if (coffee < 0) {
            println("Sorry, not enough coffee!")
            return
        } else
            if (milk < 0) {
                println("Sorry, not enough milk!")
                return
            } else
                if (coffee < 0) {
                    println("Sorry, not enough disposable cups!")
                    return
                }
    water -= 200
    coffee -= 12
    milk -= 100
    cups --
    money += 6
    println("I have enough resources, making you a coffee!")
}

fun buy() {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    val x = readln()
    println()
    when (x) {
        "1" -> espresso()
        "2" -> latte()
        "3" -> cappuccino()
        "back" -> return
    }
    println()
//    printComponents()
}

fun fill() {
    print("Write how many ml of water do you want to add: ")
    water += readln().toInt()
    println()
    print("Write how many ml of milk do you want to add: ")
    milk += readln().toInt()
    println()
    print("Write how many ml of milk do you want to add: ")
    coffee += readln().toInt()
    println()
    print("Write how many disposable cups of coffee do you want to add: ")
    cups += readln().toInt()
    println()
//    printComponents()
}

fun take() {
    print("I gave you $$money")
    money = 0
    println()
//    printComponents()
}

fun main() {
    while (true) {
        print("Write action (buy, fill, take, remaining, exit): ")
        var x = readln()
        println()
        when (x) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> printComponents()
            "exit" -> return
        }
    }
//    enterComponents()
//    coffeeCupsExit()
//    println("""For $cupsCoffee cups of coffee you will need:
//${cupsCoffee * 200} ml of water
//${cupsCoffee * 50} ml of milk
//${cupsCoffee * 15} g of coffee beans
//    """.trimMargin())
}
