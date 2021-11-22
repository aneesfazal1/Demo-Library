package com.example.demoapplication

import android.app.Application
import okhttp3.ResponseBody

import org.json.JSONException

import org.json.JSONObject

import org.json.JSONArray

import androidx.lifecycle.MutableLiveData
import com.example.demoapplication.model.CurrentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class MyRepo(application: Application?) {
    private val allCountries: MutableLiveData<ArrayList<CurrentResponse>?> =
        MutableLiveData<ArrayList<CurrentResponse>?>()
    private val countryList: ArrayList<CurrentResponse> = ArrayList()


    fun callAPI(): MutableLiveData<ArrayList<CurrentResponse>?> {
        val call: Call<ResponseBody> = RetrofitClient.instance?.getapi()?.data as Call<ResponseBody>
        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
                if (response.code() == 200) {

                    assert(response.body() != null)
                    val dataobj = JSONObject(response.body()!!.string())
//                    for (i in 0 until dataArray.length()) {
                        var modelRecycler = CurrentResponse()
                    modelRecycler.timezone = dataobj.getString("timezone")
//                        val dataobj: JSONObject = dataArray.getJSONObject(i)

                    countryList.add(modelRecycler)
                        allCountries.value = countryList
                    //}
                }
            }

            override fun onFailure(call: Call<ResponseBody?>?, t: Throwable) {
                //failed
                allCountries.postValue(null)
                println("t.getMessage() = " + t.message)
            }
        })
        return allCountries
    }
}





