package com.example.bspl

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.bspl.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val mViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            // hold splash screen
            setKeepOnScreenCondition {
                mViewModel.isLoading.value
            }
        }
        setContentView(R.layout.activity_main)
    }
}