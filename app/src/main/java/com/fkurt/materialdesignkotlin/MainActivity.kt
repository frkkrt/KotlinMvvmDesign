package com.fkurt.materialdesignkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fkurt.kotlingetmaplocation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}