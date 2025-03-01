plugins {
    alias(libs.plugins.android.application)
    id ("com.google.dagger.hilt.android")
}


android {
    namespace = "com.example.pagingexample"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.pagingexample"
        minSdk = 24
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

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.google.code.gson:gson:2.12.1")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    // RxJava3 with Retrofit
    implementation ("com.squareup.retrofit2:adapter-rxjava3:2.11.0")

    // Paging
    val paging_version = "3.3.6"
    implementation ("androidx.paging:paging-runtime:$paging_version")
    // RxJava3 support
    implementation ("androidx.paging:paging-rxjava3:$paging_version")

    // Hilt Dagger
    implementation ("com.google.dagger:hilt-android:2.55")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.55")

    // Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    // Lifecycle
    val lifecycle_version = "2.8.7"
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

}

