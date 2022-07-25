package org.lniranjan.mvi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OurApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
