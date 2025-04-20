plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

// Gradle task to generate colors.xml from Colors.kt
tasks.register("generateColorsXml", Exec::class) {
    group = "build"
    description = "Generates colors.xml from Colors.kt"
    commandLine = listOf("./generateColorsXml.main.kts")
    // Add dependency to process resources task in AGP 8.x
    if (gradle.startParameter.taskNames.any { it.contains("process") && it.contains("Resources") }) {
        val processResourcesTaskName = if (gradle.startParameter.taskNames.any { it.contains("Debug") }) {
            "processDebugResources"
        } else if (gradle.startParameter.taskNames.any { it.contains("Release") }) {
            "processReleaseResources"
        } else {
            "processResources"
        }
        tasks.named(processResourcesTaskName).configure {
            dependsOn(this@register)
        }
    } else {
        // For older AGP versions, a different hook may be needed
        // or manually run the task before building.
    }
}

android {
    namespace = "com.prototype.compose_figma_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.prototype.compose_figma_app"
        minSdk = 27
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}