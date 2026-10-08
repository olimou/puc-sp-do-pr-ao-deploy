plugins {
    kotlin("jvm") version "2.0.21"
    application
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1"
}

group = "dev.workshop"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    // Servidor web minimalista em Kotlin
    implementation("io.ktor:ktor-server-core:2.3.12")
    implementation("io.ktor:ktor-server-netty:2.3.12")
    implementation("ch.qos.logback:logback-classic:1.4.14")

    // Testes
    testImplementation("io.ktor:ktor-server-test-host:2.3.12")
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

application {
    mainClass.set("AppKt")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
