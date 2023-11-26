package com.example.interview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interview.model.UserResponceModelItem
import com.example.interview.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(var repository: UserRepository):ViewModel() {
    init {
        viewModelScope.launch {
            repository.getUser()
        }
    }
    val userss : LiveData<ArrayList<UserResponceModelItem>>
        get() = repository.users
}