package com.kris.fork.data.retrofit

import android.content.Context
import com.google.gson.GsonBuilder
import com.kris.fork.data.BuildConfig
import com.kris.fork.data.retrofit.interceptor.NetworkConnectionInterceptor
import com.kris.fork.data.retrofit.interceptor.TheForkTokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient(
    context: Context
) {

    private val retrofit: Retrofit

    init {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            })
            .addInterceptor(TheForkTokenInterceptor)
            .addInterceptor(NetworkConnectionInterceptor(context))
            .readTimeout(1, TimeUnit.MINUTES).build()

        val gson = GsonBuilder()
            .create()

        retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }


    fun <T> getService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}