package com.example.interview.splace.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.interview.R
import com.example.interview.databinding.ActivitySplaceBinding
import com.example.interview.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager0.adapter = PageAdapter(supportFragmentManager)
    }
}