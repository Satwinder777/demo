package com.example.interview.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interview.model.LoginDetails
import com.example.interview.model.UserResponceModelItem
import com.example.interview.model.rejisterDetails
import com.example.interview.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(var repository: UserRepository):ViewModel() {
    init {
        viewModelScope.launch {
            repository.getUser()
        }
    }
    val userss : LiveData<ArrayList<UserResponceModelItem>>
        get() = repository.users

    fun signUp(dtl:rejisterDetails,context:Context){
        viewModelScope.launch (Dispatchers.IO){
            repository.SignUp(dtl,context)
        }
    }

    fun login(dtl:LoginDetails,context:Context){
        viewModelScope.launch (Dispatchers.IO){
            repository.loginUser(dtl,context)
        }
    }
}