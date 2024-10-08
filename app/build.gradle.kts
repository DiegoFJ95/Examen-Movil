plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.kotlin.examenmovil"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlin.examenmovil"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.core)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.places)
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //Glide
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation(libs.play.services.fido)
    implementation(libs.androidx.espresso.core)
    implementation(libs.androidx.material3.android)
    implementation(libs.firebase.crashlytics.buildtools)
    implementation(libs.androidx.lifecycle.process)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.ui.tooling.preview.android)
    //implementation(libs.androidx.swiperefreshlayout)
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    //Data binding
    implementation ("androidx.databinding:databinding-runtime:7.1.2")
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation ("jp.wasabeef:glide-transformations:4.3.0")
    //Activity
    implementation ("androidx.activity:activity-ktx:1.5.0")
    //Material
    implementation ("com.google.android.material:material:1.9.0")
    //Fragment
    implementation ("androidx.fragment:fragment-ktx:1.5.0")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
    //Corrutinas
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    //Fragment
    implementation(libs.androidx.fragment.ktx)
    //Data Binding
    implementation(libs.androidx.databinding.runtime)
    //Activity
    implementation(libs.activity.ktx)

    //Coroutines
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)

    // ViewModel y LiveData
    implementation (libs.androidx.activity.ktx)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.livedata.ktx)

    //Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    // OkHttp
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")

    // Google Play Services Auth
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.3.0")) // Latest BOM
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")

    implementation("com.hbb20:ccp:2.7.0")
    implementation("com.googlecode.libphonenumber:libphonenumber:8.12.52")
}