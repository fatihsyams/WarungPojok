package com.example.warungpojok.network

import com.example.warungpojok.RequestInputMenu
import com.example.warungpojok.ResponseInputMenu
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

object Api {

    const val  BASE_URL = "http://warungpojok.snip-id.com/"
    fun <T : Any> createBase(service: KClass<T>, client: OkHttpClient? = null): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .let { builder ->
                client?.let { builder.client(it) } ?: builder
            }
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(service.java)
    }

    fun <T : Any> create(service: KClass<T>): T {
        val httpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)


        return createBase(service, httpClient.build())
    }

}