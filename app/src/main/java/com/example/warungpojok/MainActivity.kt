package com.example.warungpojok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(PesananFragment())


    }

    private fun loadFragment(fragment : Fragment) {
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

//    private fun setIntentFragment() {
//        tvPesananMain.setOnClickListener {
//            applicationContext?.let {
//                val intent = Intent(it, PesananFragment::class.java)
//                it.startActivity(intent)
//            }
//        }
//    }
}