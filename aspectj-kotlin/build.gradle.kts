plugins {
    kotlin("jvm") version "1.8.0"
    application
    id ("io.freefair.aspectj.post-compile-weaving") version "8.0.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.aspectj:aspectjrt:1.9.19")
    implementation("org.aspectj:aspectjweaver:1.9.19")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}