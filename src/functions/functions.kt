package functions

fun dead(hp: Int):Boolean{
    if(hp<=0) return false
    else return true
}

fun goodbye(isAlive: Boolean):String{
    if (isAlive == false) return "killed!"
    else return "nein"
}


