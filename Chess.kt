package chess
fun pole ():String {
    val pole = """  +---+---+---+---+---+---+---+---+
8 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
7 | B | B | B | B | B | B | B | B |
  +---+---+---+---+---+---+---+---+
6 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
5 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
4 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
3 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
2 | W | W | W | W | W | W | W | W |
  +---+---+---+---+---+---+---+---+
1 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
    a   b   c   d   e   f   g   h"""
    return pole
}

fun name():Pair<String,String>{
    print("First Player's name: ")
    val name1 = readln().toString()
    print("Second Player's name: ")
    val name2 = readln().toString()
    return Pair(name1,name2)
}

fun check(walkPlayer:String):String{
    val poleB = "[a-h]".toRegex()
    val poleN = "[1-8]".toRegex()
    val wPlayer = walkPlayer.toCharArray()
    var ret = ""
    var z = 0
    if (walkPlayer.equals("exit")){
        println("Bye!")
        System.exit(0)
    }
    for (i in wPlayer) {
        if (walkPlayer.length>4){
            break
        }
        if (ret.equals("noOk")) {
            break
        }
        if (z % 2 == 0) {
            if (i.toString().matches(poleB)) {
                if (!ret.equals("noOk")) ret = "Ok"
                z++
            } else ret = "noOk"
        } else  {
            if (i.toString().matches(poleN)) {
                if (!ret.equals("noOk")) ret = "Ok"
                z++
            } else ret = "noOk"
        }
    }
    return ret
}

fun walk(name1:String, name2:String){
    var walkPlayer = "noOk"
    var n1 = 0
    while (!walkPlayer.equals("exit")) {
        if (n1%2==0) {
            println("$name1's turn:")
            walkPlayer = readln().toString()
            if (check(walkPlayer).equals("Ok")) {
                n1++
            } else {
                println("Invalid Input")
            }
        }
        else {
            println("$name2's turn:")
            walkPlayer = readln().toString()
            if (check(walkPlayer).equals("Ok")) {
                n1++
            } else {
                println("Invalid Input")
            }
        }
    }
}

fun main() {
    println("Pawns-Only Chess")
    val (name1,name2) = name()
    print(pole())
    println()
    walk(name1, name2)
}
