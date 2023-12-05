package com.example.interview.new1.livestream

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.interview.R
import com.example.interview.databinding.FragmentLiveStreamBinding
import com.zegocloud.uikit.prebuilt.livestreaming.ZegoUIKitPrebuiltLiveStreamingConfig
import com.zegocloud.uikit.prebuilt.livestreaming.ZegoUIKitPrebuiltLiveStreamingFragment

class LiveStreamFragment : Fragment() {

    lateinit var binding : FragmentLiveStreamBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = FragmentLiveStreamBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        addFragment()

        binding.livebtn.setOnClickListener {
            addFragment(true)
        }
        binding.livebtn2.setOnClickListener {
            addFragment(false)
        }

    }

    private fun addFragment(isHost:Boolean) {
        val appID: Long = requireContext().getString(R.string.appid).toLong()
        val appSign = requireContext().getString(R.string.appsign)
        val userID = binding.userId.text.toString() //"12345"
        val userName = binding.userName.text.toString() //"sattasupari"

//        val isHost = intent.getBooleanExtra("host", false)
        val liveID = "12345"

        val config: ZegoUIKitPrebuiltLiveStreamingConfig = if (isHost==true) {
            Log.e(liveID, "aaaddFragment: $isHost" )

            ZegoUIKitPrebuiltLiveStreamingConfig.host()
        } else {
            Log.e(liveID, "bbaddFragment: $isHost" )

            ZegoUIKitPrebuiltLiveStreamingConfig.audience()

        }
        val fragment = ZegoUIKitPrebuiltLiveStreamingFragment.newInstance(
            appID, appSign, userID, userName, liveID, config
        )
//        LiveStreamFragment()
        //
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commitNow()
    }

}