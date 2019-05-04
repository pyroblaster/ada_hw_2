package models

data class myCharacter(
    var name: String,
    var type: String,
    var hp: Int,
    var power: Int,
    var exp: Int = 1,
    var killCount: Int = 0,
    var isAlive: Boolean)
