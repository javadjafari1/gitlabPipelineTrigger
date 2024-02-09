pluginManagement {
    repositories {
        if (File("nexus.properties").exists()) {
            val localProperties = java.util.Properties().apply {
                load(java.io.FileInputStream("nexus.properties"))
            }
            maven {
                url = uri(localProperties.getProperty("url"))
                credentials {
                    username = localProperties.getProperty("username")
                    password = localProperties.getProperty("password")
                }
            }
        }
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        kotlin("jvm").version("1.9.20")
        id("org.jetbrains.compose").version("1.5.10")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        if (File("nexus.properties").exists()) {
            val localProperties = java.util.Properties().apply {
                load(java.io.FileInputStream("nexus.properties"))
            }
            maven {
                url = uri(localProperties.getProperty("url"))
                credentials {
                    username = localProperties.getProperty("username")
                    password = localProperties.getProperty("password")
                }
            }
        }
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}

rootProject.name = "GitlabPipelineTrigger"
