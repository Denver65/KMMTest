import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id ("com.apollographql.apollo") version ("2.5.6")
//    id ("org.jetbrains.kotlin.kapt") version ("1.5.0")
}

kotlin {

    val nav_version = "2.3.5"
    val core_version = "1.5.0"
    val lifecycle_version = "2.2.0"

    val okhttp3_version = "4.9.1"
    val kotlinCoroutineVersion = "1.3.0"
    val picassoVersion = "2.5.2"
    val androidMaterialVersion = "1.3.0"
    val roomVersion = "2.3.0"
    val uiAutomatorVersion = "2.2.0"
    val testCoreVersion = "1.3.0"
    val extJUnitVersion = "1.1.2"
    val testRunnerVersion = "1.3.0"
    val apolloVersion = "2.5.6"
    val ktorVersion = "1.5.4"



    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {

                implementation ("org.jetbrains.kotlin:kotlin-reflect:1.5.0")
                //Kotlin Coroutines
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion")

                // Apollo
                implementation("com.apollographql.apollo:apollo-api:$apolloVersion")
                implementation("com.apollographql.apollo:apollo-runtime-kotlin:$apolloVersion")

                // Ktor HTTP
                implementation("io.ktor:ktor-client-core:${ktorVersion}")
                implementation("io.ktor:ktor-client-json:${ktorVersion}")
                implementation("io.ktor:ktor-client-serialization:${ktorVersion}")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))

            }
        }
        val androidMain by getting {
            dependencies {

                implementation("com.google.android.material:material:1.2.1")

                implementation ("com.google.android.material:material:$androidMaterialVersion")
                implementation ("androidx.annotation:annotation:1.2.0")
                implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
                implementation ("androidx.legacy:legacy-support-v4:1.0.0")

                implementation ("androidx.core:core-ktx:$core_version")
                implementation ("androidx.appcompat:appcompat:1.3.0")
                implementation ("androidx.constraintlayout:constraintlayout:2.0.4")
                implementation ("androidx.recyclerview:recyclerview:1.2.0")
                implementation ("androidx.cardview:cardview:1.0.0")

                // Kotlin navigation
                implementation ("androidx.navigation:navigation-fragment-ktx:$nav_version")
                implementation ("androidx.navigation:navigation-ui-ktx:$nav_version")

                implementation ("android.arch.lifecycle:viewmodel:1.1.1")

                //Kotlin Coroutines
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutineVersion")

                //Picasso for Image Loading
                implementation ("com.squareup.picasso:picasso:$picassoVersion") {
                    exclude("com.android.support")
                }

                // ViewModel
                implementation ("androidx.lifecycle:lifecycle-extensions:$lifecycle_version")
                implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
                // LiveData
                implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

                // Saved state module for ViewModel
                implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")

                // Expandable recyclerview
                implementation ("io.github.luizgrp.sectionedrecyclerviewadapter:sectionedrecyclerviewadapter:3.2.0")

                // Timeline view
                implementation ("com.github.vipulasri:timelineview:1.1.5")

                // Expandable CardView
                implementation ("com.alespero:expandable-cardview:0.8") {
                    exclude("com.android.support")
                }

//                // Room database
                implementation ("androidx.room:room-runtime:$roomVersion")

                // TODO kapt
                // kapt("androidx.room:room-compiler:$roomVersion")
                // optional - Kotlin Extensions and Coroutines support for Room
                implementation ("androidx.room:room-ktx:$roomVersion")

                //FingerPrint dialog -
                implementation ("me.aflak.libraries:fingerprint:2.5.3") {
                    exclude("com.android.support")
                }

                // CircleImageView
                implementation ("de.hdodenhof:circleimageview:3.1.0")

//                implementation ("com.github.ar-android:AndroidSvgLoader:1.0.2")
//                // https://mvnrepository.com/artifact/com.caverock/androidsvg
//                implementation ("com.caverock:androidsvg:1.4")

                // FAB Button
                implementation ("com.github.clans:fab:1.6.4")

                // Custom popup menu -
                implementation ("com.github.zawadz88.materialpopupmenu:material-popup-menu:4.1.0")

                // Material spinner https://github.com/ganfra/MaterialSpinner
                implementation ("com.github.ganfra:material-spinner:2.0.0") {
                    exclude("com.android.support")
                }

                // Яндекс Метрика
                implementation ("com.yandex.android:mobmetricalib:3.18.0")

                // Яндекс Карты
                implementation ("com.yandex.android:maps.mobile:4.0.0-lite")  {
                    exclude("com.android.support")
                }

                // DateTimePicker
                implementation ("com.wdullaer:materialdatetimepicker:4.2.3")

                // Input Mask https://github.com/RedMadRobot/input-mask-android -
                implementation ("com.redmadrobot:input-mask-android:6.0.0")
                implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.5.0")

                //KTX - fragment
                implementation ("androidx.fragment:fragment-ktx:1.4.0-alpha01")

                // Okhttp3
                implementation ("com.squareup.okhttp3:okhttp:$okhttp3_version")
                implementation ("com.squareup.okhttp3:logging-interceptor:$okhttp3_version")
                implementation("androidx.transition:transition-ktx:1.4.1")

                // Ktor
                implementation ("io.ktor:ktor-client-android:$ktorVersion")
                implementation ("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation ("io.ktor:ktor-client-gson:$ktorVersion")

                implementation ("com.google.code.gson:gson:2.8.7")

            }
        }

        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13")
            }
        }

        val iosMain by getting

        val iosTest by getting
    }
}

android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)