import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose)
}

group = "ir.thatsmejavad.pipelinetrigger"
version = "0.0.1"

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(libs.voyagerNavigator)
    implementation(libs.voyagerScreenModel)
    implementation(libs.voyagerKoin)
    implementation(libs.coroutine)
    implementation(libs.koin)
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
