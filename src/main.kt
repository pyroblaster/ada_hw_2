import functions.dead
import functions.goodbye
import models.enemy
import models.myCharacter


fun main() {
    var character = myCharacter("Xerod", "Human", 1, 1, 1, 0, true)

    println("Would you like to start your new adventure? \n y/n")
    var message: String = readLine()!!


    when (message) {
        "y" -> message = "Lets go!"
        "n" -> message = "Well, at least try it."
    }
    println(message)

    println("What is your name Champion?")
    character.name = readLine()!!

    if (character.name == "") character.name = "Helicopter"

    println("Alright, ${character.name}, do you lift weights(1) or books(2) or both(3)?")

    message = readLine()!!


    when (message) {
        "1" -> {
            character.hp = 200
            character.power = 15
            character.type = "Warrior"
        }
        "2" -> {
            character.hp = 100
            character.power = 25
            character.type = "Sorcerer"
        }
        "3" -> {
            character.hp = 150
            character.power = 20
            character.type = "Paladin"
        }
        else -> {
            println("Alright, I suppose you are a half G!")
            character.hp = 100000
            character.power = 1000000
            character.type = "Demigod"

        }
    }

    println(
            "Welcome champion ${character.name}, son of ${character.name}s father, mighty ${character.type}! It seems you are ready!" +
                    "\nAs you have chosen to be ${character.type}, your hp is ${character.hp}, and power ${character.power}, use them wisely!"
    )

    while (true) {

        if (character.exp <= 32) {
            if (character.killCount == 0) println("Something random is hiding in shadow, can you see it?")

            Thread.sleep(2500)

            var easyEnemy = enemy(
                    ('A'..'z').map { it }.shuffled().subList(0, 8).joinToString(""),
                    ('A'..'z').map { it }.shuffled().subList(0, 4).joinToString(""),
                    (25..50).random(),
                    (5..10).random(),
                    false,
                    true
            )
            while (easyEnemy.isAlive == true) {

                easyEnemy.hp = easyEnemy.hp - character.power

                println("${character.name} using its incredible iq smashes ${easyEnemy.name} for ${character.power} pure intellectual power.")
                character.hp = character.hp - easyEnemy.power
                Thread.sleep(1000)

                println("${easyEnemy.name} using its low quality iq barely hits ${character.name} for ${easyEnemy.power} damage, if that can be called damage.")
                Thread.sleep(1000)

                character.isAlive = dead(character.hp)
                easyEnemy.isAlive = dead(easyEnemy.hp)


            }
            if (character.isAlive == false) {
                println("${easyEnemy.name} using its low quality iq smashes ${character.name}.")
                println("${character.name} has been ${goodbye(character.isAlive)}, cry.")
                println("Number of kills: ${character.killCount}.")
                println("Current exp: ${character.exp}")
                println("When you reincarnate come back.")
                break
            }

            if (easyEnemy.isAlive == false) {
                character.power = character.power + 5
                character.hp = character.hp + 25
                character.exp = character.exp * 2
                character.killCount++
                println("${character.name} using its incredible iq smashes ${easyEnemy.name}.")
                println("${easyEnemy.name} has been ${goodbye(easyEnemy.isAlive)}")
                println("Your remaining hp: ${character.hp}, power: ${character.power} ,exp: ${character.exp},kills: ${character.killCount}.")
                continue
            }


            println("Want to continue?")
            message = readLine()!!
            if (message == "y")
            else {
                println("Goodbye")
                println("Number of kills: ${character.killCount}.")
                println("Current exp: ${character.exp}")
                break
            }
        }
        else if (character.exp <= 2048) {

            println("You are migty ${character.type} now! I think it is time to kill even more random enemies!")

            println("Your iq has been upgraded!")
            character.power = character.power * 8
            character.hp = character.hp * 4


            var mediumEnemy = enemy(('A'..'z').map { it }.shuffled().subList(0, 16).joinToString(""),
                    ('A'..'z').map { it }.shuffled().subList(0, 8).joinToString(""),
                    (250..1000).random(),
                    (100..200).random(),
                    false,
                    true
            )
            while (mediumEnemy.isAlive == true) {

                mediumEnemy.hp = mediumEnemy.hp - character.power

                println("${character.name} using its incredible iq smashes ${mediumEnemy.name} for ${character.power} pure intellectual power.")
                character.hp = character.hp - mediumEnemy.power
                Thread.sleep(1000)

                println("${mediumEnemy.name} using its medium quality iq hits ${character.name} for ${mediumEnemy.power} damage.")
                Thread.sleep(1000)

                character.isAlive = dead(character.hp)
                mediumEnemy.isAlive = dead(mediumEnemy.hp)

            }
            if (character.isAlive == false) {
                println("${mediumEnemy.name} using its medium quality iq smashes ${character.name}.")
                println("${character.name} has been ${goodbye(character.isAlive)}, cry.")
                println("Number of kills: ${character.killCount}.")
                println("Current exp: ${character.exp}")
                println("When you reincarnate come back.")
                break
            }
            if (mediumEnemy.isAlive == false) {
                character.power = character.power + 5
                character.hp = character.hp + 25
                character.exp = character.exp * 2
                character.killCount++
                println("${character.name} using its incredible iq smashes ${mediumEnemy.name}.")
                println("${mediumEnemy.name} has been ${goodbye(mediumEnemy.isAlive)}")
                println("Your remaining hp: ${character.hp}, power: ${character.power} ,exp: ${character.exp},kills: ${character.killCount}.")
                continue

            }

            println("Want to continue?")
            message = readLine()!!
            if (message == "y")
            else {
                println("Goodbye")
                println("Number of kills: ${character.killCount}.")
                println("Current exp: ${character.exp}")
                break
            }
        } else {
            println("How are you still alive?!? You shall die from randomness, ${character.type}!")

            println("Your iq has been upgraded!")
            character.power = character.power * 8
            character.hp = character.hp * 4

            var eliteEnemy = enemy(('A'..'z').map { it }.shuffled().subList(0, 32).joinToString(""),
                    ('A'..'z').map { it }.shuffled().subList(0, 16).joinToString(""),
                    (25000..100000).random(),
                    (150000000..300000000).random(),
                    true,
                    true
            )
            while (eliteEnemy.isAlive == true) {

                eliteEnemy.hp = eliteEnemy.hp - character.power

                println("${character.name} using its incredible iq smashes ${eliteEnemy.name} for ${character.power} pure intellectual power.")
                character.hp = character.hp - eliteEnemy.power
                Thread.sleep(1000)

                println("${eliteEnemy.name} using its high quality iq crits ${character.name} for ${eliteEnemy.power} damage, nice dmg.")
                Thread.sleep(1000)

                character.isAlive = dead(character.hp)
                eliteEnemy.isAlive = dead(eliteEnemy.hp)

            }
            if (character.isAlive == false) {
                println("${eliteEnemy.name} using its high quality iq smashes ${character.name}.")
                println("${character.name} has been ${goodbye(character.isAlive)}, cry.")
                println("Number of kills: ${character.killCount}.")
                println("Current exp: ${character.exp}")
                println("When you reincarnate come back.")
                break
            }

            if (eliteEnemy.isAlive == false) {
                character.power = character.power + 5
                character.hp = character.hp + 25
                character.exp = character.exp * 2
                character.killCount++
                println("${character.name} using its incredible iq smashes ${eliteEnemy.name}.")
                println("${eliteEnemy.name} has been ${goodbye(eliteEnemy.isAlive)}")
                println("Your remaining hp: ${character.hp}, power: ${character.power} ,exp: ${character.exp},kills: ${character.killCount}.")
                println("No posible señor, GG.")
            }

            println("Want to continue?")
            message = readLine()!!
            if (message == "y")
            else {
                println("Goodbye")
                println("Number of kills: ${character.killCount}.")
                println("Current exp: ${character.exp}")
                break
            }
        }

    }
}



