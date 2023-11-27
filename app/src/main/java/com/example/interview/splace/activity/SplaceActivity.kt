package com.example.interview.splace.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.interview.R
import com.example.interview.databinding.ActivitySplaceBinding
import com.example.interview.splace.viewpager.ViewPagerActivity

class SplaceActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplaceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed(object : Runnable{
            override fun run() {

                val intent = Intent(this@SplaceActivity,ViewPagerActivity::class.java)
                startActivity(intent)
                finishAffinity()
            }

        },5000)
    }
}