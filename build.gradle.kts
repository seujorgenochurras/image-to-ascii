plugins {
    id("java")
    id("maven-publish")
    id("signing")
    jacoco
}
repositories {
    mavenCentral()
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}
tasks.jacocoTestReport {
    dependsOn(tasks.test)
}

tasks.withType(Jar::class) {
    manifest {
        attributes["Manifest-Version"] = "1.0"
        attributes["Main-Class"] = "io.github.seujorgenochurras.demo.ImageToAscii"
    }
}
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "io.github.seujorgenochurras"
            artifactId = "image-to-ascii"
            version = "0.0.4"
            from(components["java"])

            pom {
                name.set("Image to ASCII")
                description.set("A java Image to ASCII parser with many configurable features")
                url.set("https://github.com/seujorgenochurras/image-to-ascii")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("http://www.opensource.org/licenses/mit-license.php")
                    }
                }
                developers {
                    developer {
                        id.set("LILJ")
                        name.set("Little Jhey")
                        email.set("jjotinha_oficial@outlook.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/image-to-ascii")
                    developerConnection.set("scm:git:git://github.com/image-to-ascii")
                    url.set("https://github.com/seujorgenochurras/image-to-ascii")
                }
            }
        }
    }
    repositories {
        maven {
            name = "OSSRH"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = project.properties["repoUser"].toString()
                password = project.properties["repoPassword"].toString()
            }
        }
    }
}
java {
    withJavadocJar()
    withSourcesJar()
}
signing {
    useGpgCmd()
    sign(publishing.publications["mavenJava"])
}
tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.publish{
    dependsOn(tasks.test)
}

jacoco{
    toolVersion = "0.8.11"
    reportsDirectory = layout.buildDirectory.dir("jacoco")
}

