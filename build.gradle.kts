import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose)
    alias(libs.plugins.detekt)
}

group = "ir.thatsmejavad.pipelinetrigger"
version = "0.0.1"

detekt {
    toolVersion = "1.23.3"
    config.setFrom(file("config/detekt/detekt.yml"))
    buildUponDefaultConfig = true
}

tasks.withType<Detekt>().configureEach {
    reports {
        xml.required.set(false)
        html.required.set(false)
        txt.required.set(false)
        sarif.required.set(false)
        md.required.set(false)
    }
}
dependencies {
    implementation(compose.desktop.currentOs)
    implementation(libs.voyagerNavigator)
    implementation(libs.voyagerScreenModel)
    implementation(libs.voyagerKoin)
    implementation(libs.coroutine)
    implementation(libs.koin)
    implementation(libs.lyricist)
}

compose.desktop {
    application {
        mainClass = "presentation.main.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "GitlabPipelineTrigger"
            packageVersion = "1.0.0"
        }
    }
}
