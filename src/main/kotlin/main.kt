import abstraction.AbstractWarrior
import kotlin.random.Random

fun main() {
    println("Enter the number of warriors (Team 1):")
    val team1 = createTeam()
    println("Enter the number of warriors (Team 2):")
    val team2 = createTeam()
    val battle1 = Battle("Team 1", team1, "Team 2", team2)
    battle1.battleInfo()
    battle1.battleProgress(200)
}

fun Int.isChance(): Boolean {
    return this <= Random.nextInt(0, 100)
}

fun createTeam(): MutableList<AbstractWarrior> {
    var newTeam = mutableListOf<AbstractWarrior>()

    val nWarriors = readLine()?.toInt()
    if (nWarriors != null) {
        newTeam = Team().getTeam(nWarriors)
    } else {
        println("Please enter the number")
        createTeam()
    }
    return newTeam
}