import com.diffplug.spotless.LineEnding
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar.Companion.shadowJar
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.internal.extensions.stdlib.capitalized

plugins {
    kotlin("jvm")
    idea
    jacoco
    `maven-publish`
    `java-library`
    id("com.gradleup.shadow")
    id("com.diffplug.spotless")
}

val baseGroup = "re.neotamia.ntdiscordbot"
group = when {
    project.path.startsWith(":modules:core") -> "$baseGroup.core"
    else -> baseGroup
}
version = findProperty("version")!!

val moduleName = project.path.removePrefix(":modules").replace(":", "-")
val baseName = if (moduleName == "-" || moduleName.isEmpty()) "NTDiscordBot" else "NTDiscordBot$moduleName"
base {
    archivesName.set(baseName)
}

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://jitpack.io") {
        name = "jitpack"
    }
    maven("https://repo.neotamia.re/releases") {
        name = "neotamiaReleases"
    }
    maven("https://repo.neotamia.re/snapshots") {
        name = "neotamiaSnapshots"
    }
    maven("https://repo.neotamia.re/private") {
        name = "neotamiaPrivate"
    }
    maven("https://snapshots.kord.dev") {
        name = "Kord"
    }
}

dependencies {
    compileOnly(kotlin("stdlib"))

    testImplementation(kotlin("test"))
}

java {
    withSourcesJar()
    withJavadocJar()
}

kotlin {
    jvmToolchain(21)
}

spotless {
    isEnforceCheck = findProperty("spotless.enforceCheck")?.toString()?.toBoolean() ?: true
    lineEndings = LineEnding.UNIX

    java {
        toggleOffOn()
        targetExclude("**/src/test/**")

        removeUnusedImports()
        // Cleanthat will refactor your code, but it may break your style: apply it before your formatter
        cleanthat()
        formatAnnotations()
    }

    kotlin {
        toggleOffOn()
        targetExclude("**/src/test/**")

        ktlint()
    }

    kotlinGradle {
        toggleOffOn()
        target("*.gradle.kts")
        ktlint()
    }
}

//tasks.withType<ShadowJar> {
//    archiveClassifier.set("")
//}

val copyJars = tasks.register<Copy>("copyJars") {
    group = "publishing"
    description = "Copies the built JAR to a local directory."
    from(tasks.shadowJar)
    enabled = false
}

project.afterEvaluate {
    if (project.extra.has("localJarRepo")) {
        copyJars.configure {
            into(rootProject.layout.buildDirectory.dir("repo"))
            enabled = true
        }
    }
}

tasks.build {
    dependsOn(tasks.shadowJar)
    finalizedBy(copyJars)
}

//tasks.named<Jar>("jar") {
//    archiveClassifier.set("stripped")
//}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()

    testLogging {
        events(
            TestLogEvent.FAILED,
            TestLogEvent.PASSED,
            TestLogEvent.SKIPPED
        )
    }
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

project.afterEvaluate {
    if (project.extra.has("publish")) {
        publishing {
            repositories {
                mavenLocal()
                maven {
                    var repository = System.getProperty("repository.name", "snapshots")
                    name = "neotamia${repository.capitalized()}"
                    url = uri("https://repo.neotamia.re/${repository}")
                    credentials(PasswordCredentials::class) {
                        username = (findProperty("${name}Username") ?: System.getenv("MAVEN_USERNAME")) as String?
                        password = (findProperty("${name}Password") ?: System.getenv("MAVEN_PASSWORD")) as String?
                    }
                }
            }
        }

        publishing {
            publications {
                create<MavenPublication>("mavenJava") {
                    val kebabName = baseName.replace(Regex("(?<=[a-z])(?=[A-Z])"), "-").lowercase()
                    artifactId = kebabName
                    pom {
                        name = "NTDiscordBot ${project.name}"
                        description = "NTDiscordBot, ${project.name} module."
                        url = "https://github.com/NeoTamia/NTDiscordBot"
                        developers {
                            developer {
                                id = "NeoTamia"
                                url = "https://github.com/NeoTamia"
                            }
                        }
                        scm {
                            connection = "scm:git:https://github.com/NeoTamia/NTDiscordBot.git"
                            developerConnection = "scm:git:ssh://git@github.com:NeoTamia/NTDiscordBot.git"
                            url = "https://github.com/NeoTamia/NTDiscordBot"
                        }
                    }
                    // javadoc & sources jars already added with `components["java"]`
                    from(components["java"])
                }
            }
        }
    }
}
