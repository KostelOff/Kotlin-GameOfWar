package sealedAndEnum

import isChance

enum class Ammo(

    var damage: Int,
    val criticalChanceDamage: Int,
    val criticalDamage: Int
) {
    JUNIOR_BULLETS(10, 20, 2),
    MIDDLE_BULLETS(15, 25, 2),
    SENIOR_BULLETS(20, 30, 3);

    fun getCurrentDamage(): Int {
        return if (criticalChanceDamage.isChance())
            damage * criticalDamage
        else damage
    }
}