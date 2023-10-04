plugins {
    id("java")
}
repositories {
    mavenCentral()
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("io.metaloom.video:video4j:1.3.0")
}
tasks.test {
    useJUnitPlatform()
}
