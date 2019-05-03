fun dead(hp: Int):Boolean{
    if(hp<=0) return false
    else return true
}
fun goodbye(isAlive: Boolean):String{
    if (isAlive == false) return "killed!"
    else return "nein"
}

data class myCharacter(
    var name: String,
    var type: String,
    var hp: Int,
    var power: Int,
    var isAlive: Boolean)

class enemy(
    val name: String,
    val type: String,
    var hp: Int,
    var power: Int,
    val elite: Boolean,
    var isAlive: Boolean
    )

fun main() {
    var character = myCharacter("Xerod", "Human", 1, 1, true)

    println("Would you like to start your new adventure? \n y/n")
    var message: String = readLine()!!
    var killCounter:Int = 0

    when(message){
        "y" -> message = "Lets go!"
        "n" -> message = "Well, at least try it."
    }
    println(message)

    println("What is your name Champion?")
    character.name = readLine()!!

    if(character.name == "") character.name = "Helicopter"

    println("Alright, ${character.name}, do you lift weights or books?")

    var type: String = readLine()!!

    if(type == "books"){
        character.hp = 100
        character.power = 25
        character.type = "Sorcerer"
    }
    else if(type == "weights"){
        character.hp = 200
        character.power = 15
        character.type = "Warrior"
    }
    else println("Alright, I suppose you are a demigod!")
        character.hp = 100000
        character.power = 1000000
        character.type = "Demigod"

    println("Welcome champion ${character.name}, son of ${character.name}s father, mighty ${character.type}! It seems you are ready!")

    while(true){
        var newEnemy = enemy("ripple", "bad_boi", 10, 1, false, true)
        println("Something is hiding in shadow, can you see it?")
        message = readLine()!!
        if(message != "n") {
            newEnemy.hp = newEnemy.hp - character.power
            newEnemy.isAlive = dead(newEnemy.hp)
            if(newEnemy.isAlive == false){
                println("${character.name} using its incredible iq smashes ${newEnemy.name}.")
                println("${newEnemy.name} has been ${goodbye(newEnemy.isAlive)}")
                killCounter++
                character.power++
                println(character.power)
            }

        }
        else println("Who cares...")
        println("Want to continue?")
        message = readLine()!!
        if(message == "y") println("Naaaah!")
        else {
            println("Goodbye")
            break
        }
    }
    println("Number of kills: $killCounter.")
}
