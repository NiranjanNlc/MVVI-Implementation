package org.lniranjan.mvi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.lniranjan.mvi.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}