package com.example.warungpojok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.warungpojok.fragment.PesananFragment
import com.example.warungpojok.fragment.inputmenu.InputMenuFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(InputMenuFragment())


    }

    private fun loadFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction()
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