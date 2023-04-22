plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

android {
    namespace = AppConfig.namespace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation ("androidx.core:core-ktx:${Versions.AndroidX.core}")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifecyle}")
    implementation ("androidx.activity:activity-compose:${Versions.Compose.activity}")
    implementation ("androidx.compose.ui:ui:${Versions.Compose.ui}")
    implementation ("androidx.compose.ui:ui-tooling-preview:${Versions.Compose.uiPreview}")
    implementation ("androidx.compose.material:material:${Versions.Compose.material}")
}