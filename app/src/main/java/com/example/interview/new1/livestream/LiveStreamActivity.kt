package com.example.interview.new1.livestream

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.android.billingclient.BuildConfig
import com.example.interview.R
import com.example.interview.databinding.ActivityLiveStreamBinding
import com.zegocloud.uikit.prebuilt.livestreaming.ZegoUIKitPrebuiltLiveStreamingConfig
import com.zegocloud.uikit.prebuilt.livestreaming.ZegoUIKitPrebuiltLiveStreamingFragment

class LiveStreamActivity : AppCompatActivity() {
    lateinit var binding:ActivityLiveStreamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveStreamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container,LiveStreamFragment())
            .commit()
//        addFragment()
    }

//    private fun addFragment() {
//        val appID: Long = "768947471".toLong()
//        val appSign = "6bd89388580bae031b67ad0b6f1bb3584f4b73d30a0c5584490b0a7ba72630f3"
//        val userID = "12345"//binding.userId.text.toString()
//        val userName = "sattasupari"//binding.userName.text.toString()
//
////        val isHost = intent.getBooleanExtra("host", false)
//        val liveID = "12345"
//
//        val config: ZegoUIKitPrebuiltLiveStreamingConfig = if (true) {
//            ZegoUIKitPrebuiltLiveStreamingConfig.host()
//        } else {
//            ZegoUIKitPrebuiltLiveStreamingConfig.audience()
//        }
//        val fragment = ZegoUIKitPrebuiltLiveStreamingFragment.newInstance(
//            appID, appSign, userID, userName, liveID, config
//        )
////        LiveStreamFragment()
//            //
//             supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, fragment)
//            .commitNow()
//    }



}