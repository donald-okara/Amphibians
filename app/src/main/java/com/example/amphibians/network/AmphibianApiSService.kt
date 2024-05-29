package com.example.amphibians.network

import com.example.amphibians.model.Amphibian
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =

    "https://android-kotlin-fun-mars-server.appspot.com"
//https://android-kotlin-fun-mars-server.appspot.com/amphibians
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()



interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getAmphibians() : List<Amphibian>
}
//
//object MarsApi {
//    val retrofitService : MarsApiService by lazy{
//        retrofit.create(MarsApiService::class.java)
//    }
//}

object AmphibianApi {
    val retrofitService : AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java) }

}