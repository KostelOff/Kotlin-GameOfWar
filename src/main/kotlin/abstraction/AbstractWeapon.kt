package abstraction

import sealedAndEnum.Ammo
import Firetype
import Stack

abstract class AbstractWeapon(
    val maxAmmoMagazine: Int,
    val fireType: Firetype,
    var weaponMagazine: Stack<Ammo> = Stack()

) {
    open val isMagazineEmpty: Boolean
        get() = weaponMagazine.list.size <= 0

    abstract fun createAmmoForWeapon(): Ammo

    fun reload() {
        val newMagazine: Stack<Ammo> = Stack()
        for (i in 0 until maxAmmoMagazine) {
            newMagazine.push(createAmmoForWeapon())
            weaponMagazine = newMagazine
        }
    }

    fun getAmmoForShot(): List<Ammo> {
        val ammoList = mutableListOf<Ammo>()
        val ammoCount = when (fireType) {
            is Firetype.SingleShot -> 1
            is Firetype.AutomaticFire -> fireType.fireSize
        }
        for (i in 0 until ammoCount) {
            ammoList.add(weaponMagazine.pop() ?: break)
        }
        return ammoList
    }
}