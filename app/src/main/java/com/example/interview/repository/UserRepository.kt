package com.example.interview.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.interview.ApiInterface.ApiInterface
import com.example.interview.ApiInterface.LoginApiInterface
import com.example.interview.model.LoginDetails
import com.example.interview.model.UserResponceModelItem
import com.example.interview.model.rejisterDetails

class UserRepository(var api : ApiInterface,var api1 : LoginApiInterface){

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
    suspend fun loginUser(loginDtl :LoginDetails,context: Context){
        var login = api1.login(loginDtl)
        if (login.code()==200){
//            Toast.makeText(context, "successfully Login", Toast.LENGTH_SHORT).show()
            Log.e("SignUp10", "SignUp: successfully SignUp", )

        }else{
//            Toast.makeText(context, "Failed To Login", Toast.LENGTH_SHORT).show()
            Log.e("SignUp11", "SignUp: ${login.errorBody()}${login.code()}", )

        }
    }


    suspend fun SignUp(signupdtl: rejisterDetails,context: Context){
        var signUp = api1.register(signupdtl)
        if (signUp.code()==200){
//            Toast.makeText(context, "successfully SignUp", Toast.LENGTH_SHORT).show()
            Log.e("SignUp10", "SignUp: successfully SignUp", )
        }else{
            Log.e("SignUp11", "SignUp: ${signUp.errorBody()}${signUp.code()}" )

//            Toast.makeText(context, "Failed To SignUp", Toast.LENGTH_SHORT).show()
        }
    }

}