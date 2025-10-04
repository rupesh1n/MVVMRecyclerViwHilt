import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.android)
    id ("kotlin-kapt")
}

android {
    namespace = "com.rupesh.mvvmrecyclerviwhilt"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.rupesh.mvvmrecyclerviwhilt"
        minSdk = 28
        targetSdk = 36
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
    // Retrofit core library
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Converter for JSON serialization/deserialization using Gson
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //Dagger Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    //compose specific library for navigation & state-management
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.0-beta01")
    implementation ("androidx.navigation:navigation-compose:2.5.3")
    //Coil for showing image
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation("androidx.compose.material3:material3:1.4.0")
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.espresso.core)
}