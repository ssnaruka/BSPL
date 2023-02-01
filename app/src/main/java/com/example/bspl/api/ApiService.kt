package com.example.bspl.api

import com.example.bspl.models.StringersData
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {

    @GET(Apis.END_POINT)
    suspend fun getStringer(): Response<StringersData>?

    @POST(Apis.END_POINT)
    fun addStringer(params: HashMap<String, String>): Response<StringersData>

    @PUT(Apis.END_POINT)
    fun updateStringer(params: HashMap<String, String>): Response<StringersData>

    @DELETE(Apis.END_POINT)
    fun deleteStringer(params: HashMap<String, String>): Response<StringersData>
}