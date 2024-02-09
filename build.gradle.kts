import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import java.util.Properties
import java.io.FileInputStream

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "ir.thatsmejavad.pipelinetrigger"
version = "0.0.1"

dependencies {
    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "GitlabPipelineTrigger"
            packageVersion = "1.0.0"
        }
    }
}
