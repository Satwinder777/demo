package com.example.interview.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.interview.MainActivity
import com.example.interview.databinding.ActivityLoginBinding
import com.example.interview.model.LoginDetails
import com.example.interview.model.rejisterDetails
import com.example.interview.new1.websocket.ProductBillingActivity

import com.example.interview.repository.UserRepository
import com.example.interview.retrofitHelper.RetrofitHelper
import com.example.interview.viewmodel.MyViewModelFactory
import com.example.interview.viewmodel.UserViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var repository = UserRepository(RetrofitHelper.service, RetrofitHelper.service1)
        var viewModel = ViewModelProvider(this, MyViewModelFactory(repository)).get(UserViewModel::class.java)
        var i=0
        binding.SignUp.setOnClickListener {
//            Toast.makeText(this, "under Development !!", Toast.LENGTH_SHORT).show()
            var signdtl = rejisterDetails(
                email = binding.emailet.text.toString(),
                birth_date = "1989-10-25",
                country = "spain",
                fcm_token = "dwcwd",
                password = binding.passwordId.text.toString(),
                sponsor_id = "dww",
                username = binding.firstnameid.toString()+" "+binding.lastnameid.text.toString()
            )
            var logindtl =LoginDetails(
                device_type = "Android",
                email = binding.emailet.text.toString(),
                password = binding.passwordId.text.toString(),
                fcm_token = "fcm"
            )

//            viewModel.signUp(signdtl,this)
            viewModel.login(logindtl,this)

            i+=1
            MainActivity().clicked(i,this)
            var intent = Intent(this,ProductBillingActivity::class.java)
            startActivity(intent)
        }
    }
}