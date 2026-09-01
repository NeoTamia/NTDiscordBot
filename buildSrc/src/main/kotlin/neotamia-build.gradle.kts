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

val baseGroup = "re.neotamia.kotlintemplate"
group = when {
    project.path.startsWith(":modules:core") -> "$baseGroup.core"
    else -> baseGroup
}
version = findProperty("version")!!

val moduleName = project.path.removePrefix(":modules").replace(":", "-")
val baseName = if (moduleName == "-" || moduleName.isEmpty()) "kotlin-template" else "kotlin-template$moduleName"
base {
    archivesName.set(baseName)
}

repositories {
    mavenCentral()
    mavenLocal()
    maven {
        name = "jitpack"
        url = uri("https://jitpack.io")
    }
    maven {
        name = "neotamiaReleases"
        url = uri("https://repo.neotamia.re/releases")
    }
    maven {
        name = "neotamiaSnapshots"
        url = uri("https://repo.neotamia.re/snapshots")
    }
    maven {
        name = "neotamiaPrivate"
        url = uri("https://repo.neotamia.re/private")
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
                        name = "KotlinTemplate ${project.name}"
                        description = "Kotlin Template, ${project.name} module."
                        url = "https://github.com/NeoTamia/kotlin-template"
                        developers {
                            developer {
                                id = "NeoTamia"
                                url = "https://github.com/NeoTamia"
                            }
                        }
                        scm {
                            connection = "scm:git:https://github.com/NeoTamia/kotlin-template.git"
                            developerConnection = "scm:git:ssh://git@github.com:NeoTamia/kotlin-template.git"
                            url = "https://github.com/NeoTamia/kotlin-template"
                        }
                    }
                    // javadoc & sources jars already added with `components["java"]`
                    from(components["java"])
                }
            }
        }
    }
}
