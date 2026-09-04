plugins {
    id("ntdiscordbot-build")
}

extra["localJarRepo"] = true

dependencies {
    implementation(libs.kord)
}
