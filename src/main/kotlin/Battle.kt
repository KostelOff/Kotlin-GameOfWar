import abstraction.AbstractWarrior
import sealedAndEnum.BattleState
import kotlin.random.Random

class Battle(
    val nameForFirstTeam: String,
    var firstTeam: MutableList<AbstractWarrior>,
    val nameForSecondTeam: String,
    var secondTeam: MutableList<AbstractWarrior>
) {

    private var endBattle = false
    private  var state: BattleState = BattleState.Progress
    private var winningTeam = nameForFirstTeam

    private  fun getStatusOfBattle() {
        when {
            firstTeam.size > 0 && secondTeam.size > 0 -> {
                endBattle = false

            }
            firstTeam.size == 0 && secondTeam.size == 0 -> {
                endBattle = true
                state = BattleState.Draw
            }
            firstTeam.size == 0 -> {
                endBattle = true
                state = BattleState.Success(secondTeam)
                winningTeam = nameForSecondTeam
            }
            secondTeam.size == 0 -> {
                endBattle = true
                state = BattleState.Success(firstTeam)

            }
        }
    }

    private fun checkBattleState() {
        when (state) {
            is BattleState.Progress -> {
                println("Battle continue")
            }
            is BattleState.Success -> {
                println("${winningTeam} Won")

            }
            is BattleState.Draw -> {
                println("Draw")
            }
        }

    }

    fun battleProgress(n: Int) {
        removeKilledWarrior()
        getStatusOfBattle()
        println("Start the Battle of $nameForFirstTeam against $nameForSecondTeam")
        for (i in 0..n) {
            if (!endBattle) {
                attack(getRandomWarrior(firstTeam), getRandomWarrior(secondTeam))
                removeKilledWarrior()
                getStatusOfBattle()
                if (!endBattle) {
                    attack(getRandomWarrior(secondTeam), getRandomWarrior(firstTeam))
                }
                removeKilledWarrior()
                getStatusOfBattle()
            }
        }
        checkBattleState()
        println("The $nameForSecondTeam was left with ${secondTeam.size} warriors")
        println("The $nameForFirstTeam was left with ${firstTeam.size} warriors")

    }

    private  fun attack(whoAttacks: AbstractWarrior, whoIsAttacked: AbstractWarrior) {
        return whoAttacks.attack(whoIsAttacked)
    }

    private fun getRandomWarrior(team: MutableList<AbstractWarrior>): AbstractWarrior {
        return team[Random.nextInt(0, team.size)]


    }     //Cleaning the list of Killed

    private  fun removeKilledWarrior() {
        firstTeam
            .filter { it.currentHealth <= 0 }
            .forEach { firstTeam.remove(it) }

        secondTeam
            .filter { it.currentHealth <= 0 }
            .forEach { secondTeam.remove(it) }
    }

    fun battleInfo() {
        BattleState.Progress.info(firstTeam, nameForFirstTeam, secondTeam, nameForSecondTeam)
    }
}