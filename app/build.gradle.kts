plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.rtspplayer"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.rtspplayer"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

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
}

dependencies {

    implementation(libs.androidx.leanback)
    implementation(libs.glide)
    dependencies {
        implementation("androidx.leanback:leanback:1.2.0") // Android TV UI
        implementation("com.google.android.exoplayer:exoplayer:2.19.0") // ExoPlayer
        implementation("com.google.android.exoplayer:extension-rtsp:2.19.0") // RTSP підтримка
        implementation("org.jmdns:jmdns:3.5.5") // Пошук пристроїв у мережі
    }
}