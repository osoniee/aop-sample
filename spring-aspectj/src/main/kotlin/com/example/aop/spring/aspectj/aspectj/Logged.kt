package aspectj

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Logged(val logBefore: Boolean = true, val logAfter: Boolean = true, val logAround: Boolean = true)
