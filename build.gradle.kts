import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "ir.thatsmejavad.pipelinetrigger"
version = "0.0.1"

dependencies {
    val voyagerVersion = "1.0.0"
    val koinVersion = "3.5.3"
    implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-screenmodel:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-koin:$voyagerVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.7.3")

    implementation("io.insert-koin:koin-core:$koinVersion")

    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "presentation.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "GitlabPipelineTrigger"
            packageVersion = "1.0.0"
        }
    }
}
