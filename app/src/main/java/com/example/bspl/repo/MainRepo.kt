package com.example.bspl.repo

import android.util.Log
import com.example.bspl.api.ApiService
import com.example.bspl.models.StringersData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogeshpaliyal.universalAdapter.utils.Resource
import javax.inject.Inject

private const val TAG = "MainRepo"

class MainRepo @Inject constructor(private val apiService: ApiService) {

    suspend fun getStringers(): Resource<StringersData> {
        try {
            val result = apiService.getStringer()
            if (result?.body() != null) {
                Log.d(TAG, "getStringers: ${result.body()}")

                val type = object : TypeToken<StringersData>() {}.type
                val model = Gson().fromJson<StringersData>(result.body().toString(), type)

                Log.d(TAG, "getStringers: ${model.size}")
                return Resource.success(null, "")

            } else {
                Log.e(TAG, "getStringers: ${result?.message()}")
                return Resource.error("")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return Resource.error("")
        }
    }
}