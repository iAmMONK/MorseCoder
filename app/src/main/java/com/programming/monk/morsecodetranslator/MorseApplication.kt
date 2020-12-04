package com.programming.monk.morsecodetranslator

import android.app.Application
import com.google.android.gms.ads.MobileAds

class MorseApplication: Application() {


    override fun onCreate() {
        super.onCreate()

        MobileAds.initialize(this) {}
    }
}