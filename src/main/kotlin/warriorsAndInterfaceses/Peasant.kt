package warriorsAndInterfaceses

import abstraction.AbstractWarrior
import abstraction.AbstractWeapon
import Weapons

class Peasant() : AbstractWarrior() {
    override val maxHealth: Int = 100
    override val accuracy: Int = 20
    override val weapon: AbstractWeapon = Weapons.createPistol()
    override var currentHealth: Int = maxHealth
    override var isKilled: Boolean = currentHealth <= 0
    override val chanceToAvoidBeingHit: Int = 20
}