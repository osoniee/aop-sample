package fly

open class IronMan: Flyable {
    override fun fly() {
        println("-------I am Iron Man-------")
    }

    override fun fall() {
        println("-------I love you 3000-------")
    }
}