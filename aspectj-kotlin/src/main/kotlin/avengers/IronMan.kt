package avengers

import aspectj.Logged

open class IronMan: Flyable {
    @Logged
    override fun fly() {
        println("-------I am Iron Man-------")
    }
    @Logged
    override fun fall() {
        println("-------I love you 3000-------")
    }
}