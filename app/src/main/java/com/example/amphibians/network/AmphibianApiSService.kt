package com.example.amphibians.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"
//https://android-kotlin-fun-mars-server.appspot.com/amphibians
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): String

}

object AmphibianApi {
    val retrofitService : AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java) }

}