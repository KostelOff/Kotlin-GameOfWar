package warriorsAndInterfaceses

interface Warrior {
    var isKilled: Boolean
    val chanceToAvoidBeingHit: Int
    fun attack(enemy: Warrior)
    fun getDamage(quantityDamage: Int) {}
}