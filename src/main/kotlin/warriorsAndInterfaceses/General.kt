import abstraction.AbstractWarrior
import abstraction.AbstractWeapon

class General() : AbstractWarrior() {
    override val maxHealth: Int = 200
    override val accuracy: Int = 50
    override val weapon: AbstractWeapon = Weapons.createBlaster()
    override var currentHealth: Int = maxHealth
    override var isKilled = currentHealth <= 0
    override val chanceToAvoidBeingHit: Int = 50
}