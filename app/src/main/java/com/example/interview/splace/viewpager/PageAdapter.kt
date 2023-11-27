package com.example.interview.splace.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.interview.splace.fragments.FirstFragment
import com.example.interview.splace.fragments.SecondFragment
import com.example.interview.splace.fragments.ThirdFragment

class PageAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return FirstFragment()
            }
            1 -> {
                return SecondFragment()
            }
            2 -> {
                return ThirdFragment()
            }
            else -> {
                return FirstFragment()
            }
        }
    }



}
