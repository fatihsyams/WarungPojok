package com.example.warungpojok.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

import com.example.warungpojok.fragment.inputmenu.tabbar.CekMenuFragment
import com.example.warungpojok.fragment.inputmenu.tabbar.inputmenus.InputMenusFragment

class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val pages = listOf(
        InputMenusFragment(),
        CekMenuFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    // judul untuk tabs
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Input Menu"
            else -> "Cek Menu"
        }
    }

}