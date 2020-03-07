package com.kris.fork.data.retrofit.interceptor

import com.kris.fork.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

object TheForkTokenInterceptor : Interceptor {

    private const val API_TOKEN_KEY = "key"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url =
            request.url.newBuilder().addQueryParameter(API_TOKEN_KEY, BuildConfig.API_KEY).build()
        val newRequest = request.newBuilder().url(url).build()
        return chain.proceed(newRequest)
    }
}