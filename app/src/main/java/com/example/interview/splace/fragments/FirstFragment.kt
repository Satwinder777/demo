package com.example.interview.splace.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.interview.R
import com.example.interview.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       var viewPager =  activity?.findViewById<ViewPager>(R.id.viewPager0)
        binding.btn1.setOnClickListener {
            viewPager?.setCurrentItem(1,true)
        }
    }

}