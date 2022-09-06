sealed class Firetype {
    data class AutomaticFire(val fireSize: Int) : Firetype()
    object SingleShot : Firetype()
}