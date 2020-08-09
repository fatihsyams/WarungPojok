package com.example.warungpojok.network

import com.example.warungpojok.RequestInputMenu
import com.example.warungpojok.ResponseInputMenu
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface WarungPojokService {
    @POST("api/menu/create")
    fun inputMenu(@Body inputMenu: RequestInputMenu): Call<ResponseInputMenu>

    companion object {
        private val BASE_URL = "http://warungpojok.snip-id.com/"

        fun create(): WarungPojokService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(WarungPojokService::class.java)
        }
    }


}