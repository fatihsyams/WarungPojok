package com.example.warungpojok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setIntentFragment()

    }
    private fun setIntentFragment() {
        tvPesananMain.setOnClickListener {
            applicationContext?.let {
                val intent = Intent(it, PesananFragment::class.java)
                it.startActivity(intent)
            }
        }
    }
}