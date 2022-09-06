import abstraction.AbstractWarrior
import abstraction.AbstractWeapon

class Captain() : AbstractWarrior() {
    override val maxHealth: Int = 150
    override val accuracy: Int = 40
    override val weapon: AbstractWeapon = Weapons.createMachinegun()
    override var currentHealth: Int = maxHealth
    override var isKilled: Boolean = currentHealth <= 0
    override val chanceToAvoidBeingHit: Int = 40
}