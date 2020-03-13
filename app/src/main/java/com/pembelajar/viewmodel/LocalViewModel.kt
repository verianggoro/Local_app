package com.pembelajar.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pembelajar.model.Local
import com.pembelajar.utils.NetworkHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LocalViewModel: ViewModel(){
    private var dataLocal : MutableLiveData<Local> = MutableLiveData()
    fun sendReq(){
        NetworkHelper.services.getAll().enqueue(object : Callback<Local> {
            override fun onFailure(call: Call<Local>, t: Throwable) {
                Log.i("HOLA", t.message)
            }
            override fun onResponse(call: Call<Local>, response: Response<Local>) {
                if (response.code() == 200){
                    dataLocal.postValue(response.body())
                }
            }
        })
    }
    fun getData(): LiveData<Local> = dataLocal
}
