plugins {
    kotlin("jvm") version "2.4.10"
    id("org.jetbrains.compose") version "1.10.0"
    id("org.jetbrains.kotlin.plugin.compose") version "2.3.21"
}

group = "ie.setu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("org.jetbrains.compose.material3:material3-desktop:1.4.3")
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    jvmToolchain(25)
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}

//This Test entry is required so that JUnit can find the tests
tasks.test {
    useJUnitPlatform()
}