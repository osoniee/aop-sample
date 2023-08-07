import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.mysql:mysql-connector-j")

    implementation ("org.springframework:spring-instrument")
    implementation("com.querydsl:querydsl-jpa:5.0.0")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework:spring-aspects:6.0.11")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

fun instrumentLibPath() = sourceSets.getByName("main").compileClasspath.find { it.name.contains("spring-instrument") }
fun aspectjLibPath() = sourceSets.getByName("main").compileClasspath.find { it.name.contains("aspectjweaver") }

tasks.test {
    doFirst {
        println(instrumentLibPath())
        println(aspectjLibPath())
        jvmArgs(
            "-javaagent:${instrumentLibPath()}",
            "-javaagent:${aspectjLibPath()}",
            "--add-opens=java.base/java.lang=ALL-UNNAMED"
        )
    }
}

tasks.bootRun {
    doFirst {
        println(instrumentLibPath())
        println(aspectjLibPath())
        jvmArgs(
            "-javaagent:${instrumentLibPath()}",
            "-javaagent:${aspectjLibPath()}",
            "--add-opens=java.base/java.lang=ALL-UNNAMED"
        )
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
