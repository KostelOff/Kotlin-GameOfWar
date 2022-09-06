package sealedAndEnum

import Captain
import General
import Soldier
import abstraction.AbstractWarrior
import warriorsAndInterfaceses.Peasant

sealed class BattleState {
    object Progress : BattleState() {
        fun info(
            firstTeam: MutableList<AbstractWarrior>,
            nameOfFirstTeam: String,
            secondTeam: MutableList<AbstractWarrior>,
            nameOfSecondTeam: String
        ) {
            println(
                " Sum of $nameOfFirstTeam team health ${firstTeam.sumOf { it.currentHealth }},\n" +
                        " Sum of $nameOfSecondTeam team health ${secondTeam.sumOf { it.currentHealth }}"
            )
            println(
                "Sum of warriors in the $nameOfFirstTeam team - ${firstTeam.size},\n" +
                        "Sum of warriors in the $nameOfSecondTeam team - ${secondTeam.size}"
            )
            println("in $nameOfFirstTeam team are:\n" +
                    " Peasant = ${firstTeam.count { it is Peasant }},\n Soldier = ${firstTeam.count { it is Soldier }},\n" +
                    " Captain = ${firstTeam.count { it is Captain }},\n General = ${firstTeam.count { it is General }}"
            )
            println("in $nameOfSecondTeam team are:\n" +
                    " Peasant = ${secondTeam.count { it is Peasant }},\n Soldier = ${secondTeam.count { it is Soldier }},\n" +
                    " Captain = ${secondTeam.count { it is Captain }},\n General = ${secondTeam.count { it is General }}"
            )
        }
    }

    data class Success(val team: MutableList<AbstractWarrior>) : BattleState()
    object Draw : BattleState()
}