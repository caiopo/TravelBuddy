package br.com.caiopo.travelbuddy.util

import android.arch.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LiveDataResponseHelper<T>(
        val liveData: MutableLiveData<T>
) : Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
    }
}
