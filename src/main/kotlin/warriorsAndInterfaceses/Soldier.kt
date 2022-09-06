import abstraction.AbstractWarrior
import abstraction.AbstractWeapon

class Soldier() : AbstractWarrior() {
    override val maxHealth: Int = 120
    override val accuracy: Int = 30
    override val weapon: AbstractWeapon = Weapons.createShotgun()
    override var currentHealth: Int = maxHealth
    override var isKilled: Boolean = currentHealth <= 0
    override val chanceToAvoidBeingHit: Int = 30
}