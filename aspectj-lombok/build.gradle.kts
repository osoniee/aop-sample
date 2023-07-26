plugins {
    id("java")
    id ("io.freefair.aspectj.post-compile-weaving") version "8.0.1"
    id ("io.freefair.lombok") version "8.0.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("org.projectlombok:lombok:1.18.28")

    implementation("ch.qos.logback:logback-classic:1.4.8")
    implementation("org.slf4j:slf4j-api:2.0.7")
    compileOnly("org.projectlombok:lombok:1.18.28")

    implementation("org.aspectj:aspectjrt:1.9.19")
    implementation("org.aspectj:aspectjweaver:1.9.19")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}