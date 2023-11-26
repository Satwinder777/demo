package com.example.interview.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.interview.ApiInterface.ApiInterface
import com.example.interview.model.UserResponceModelItem

class UserRepository(var api : ApiInterface){

    private var userList = MutableLiveData<ArrayList<UserResponceModelItem>>()
    val users : LiveData<ArrayList<UserResponceModelItem>>
        get() = userList

    suspend fun getUser(){
        if (api.getAllUser().code()==200){
           userList.postValue( api.getAllUser().body())
            Log.e("detailsusers", "0000getUser:${api.getAllUser().code()} ", )
        }else{
            Log.e("detailsusers", "1111getUser:${api.getAllUser().code()} ", )

        }

    }

}