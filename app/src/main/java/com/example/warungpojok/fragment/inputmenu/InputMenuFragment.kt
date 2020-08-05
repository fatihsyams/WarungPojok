package com.example.warungpojok.fragment.inputmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warungpojok.R
import com.example.warungpojok.adapter.PagerAdapter
import kotlinx.android.synthetic.main.fragment_input_menu.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InputMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputMenuFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewpager_main.adapter = PagerAdapter(fragmentManager!!)
        tabsMain.setupWithViewPager(viewpager_main)

    }

}