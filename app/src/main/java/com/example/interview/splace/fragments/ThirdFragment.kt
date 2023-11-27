package com.example.interview.splace.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.viewpager.widget.ViewPager
import com.example.interview.R
import com.example.interview.databinding.FragmentThirdBinding
import com.example.interview.login.LoginActivity

class ThirdFragment : Fragment() {


    lateinit var binding: FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var viewPager =  activity?.findViewById<ViewPager>(R.id.viewPager0)
        binding.btn3.setOnClickListener {
//            viewPager?.setCurrentItem(1,true)
            val intent = Intent(requireContext(),LoginActivity::class.java)
            startActivity(intent)
//            fini
            finishAffinity(requireActivity())
        }
    }

}