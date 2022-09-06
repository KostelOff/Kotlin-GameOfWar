package abstraction

import warriorsAndInterfaceses.Warrior
import isChance

abstract class AbstractWarrior : Warrior {
    abstract val maxHealth: Int
    abstract val accuracy: Int
    abstract val weapon: AbstractWeapon
    abstract var currentHealth: Int
    abstract override val chanceToAvoidBeingHit: Int
    abstract override var isKilled: Boolean

    override fun attack(enemy: Warrior) {
        val currentDamage = weapon.createAmmoForWeapon().getCurrentDamage()
        val ammoForShot = weapon.getAmmoForShot()
        if (weapon.isMagazineEmpty) {
            weapon.reload()
        } else {
            ammoForShot.forEach {
                if (accuracy.isChance() && !enemy.chanceToAvoidBeingHit.isChance()) {
                    enemy.getDamage(currentDamage)
                }
            }
        }
    }

    override fun getDamage(quantityDamage: Int) {
        if (currentHealth > quantityDamage) currentHealth -= quantityDamage
        else {
            currentHealth = 0
            isKilled = true
        }
    }
}