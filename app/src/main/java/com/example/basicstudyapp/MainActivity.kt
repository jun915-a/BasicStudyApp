package com.example.basicstudyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicstudyapp.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
