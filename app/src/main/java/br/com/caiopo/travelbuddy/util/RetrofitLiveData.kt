package br.com.caiopo.travelbuddy.util

import android.arch.lifecycle.LiveData
import br.com.caiopo.travelbuddy.model.api.ApiException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitLiveData<T> : LiveData<ErrorWrapper<T>>(), Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (!response.isSuccessful || response.body() == null) {
            postValue(ErrorWrapper(error = ApiException()))
        }

        postValue(ErrorWrapper(value = response.body()))
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        postValue(ErrorWrapper(error = t))
    }
}
