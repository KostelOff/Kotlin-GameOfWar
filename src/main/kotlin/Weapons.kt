import abstraction.AbstractWeapon
import sealedAndEnum.Ammo

object Weapons {


    fun createPistol(): AbstractWeapon {
        return object : AbstractWeapon(10, Firetype.SingleShot) {
            override fun createAmmoForWeapon(): Ammo {
                return Ammo.JUNIOR_BULLETS
            }

        }
    }

    fun createShotgun(): AbstractWeapon {
        return object : AbstractWeapon(12, Firetype.AutomaticFire(2)) {
            override fun createAmmoForWeapon(): Ammo {
                return Ammo.MIDDLE_BULLETS
            }
        }

    }

    fun createMachinegun(): AbstractWeapon {
        return object : AbstractWeapon(30, Firetype.AutomaticFire(5)) {
            override fun createAmmoForWeapon(): Ammo {
                return Ammo.MIDDLE_BULLETS
            }
        }
    }

    fun createBlaster(): AbstractWeapon {
        return object : AbstractWeapon(50, Firetype.AutomaticFire(10)) {
            override fun createAmmoForWeapon(): Ammo {
                return Ammo.SENIOR_BULLETS
            }
        }
    }
}