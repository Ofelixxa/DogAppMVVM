package com.example.dogappmvvm

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogRepository {
    private val api = Retrofit.Builder()
        .baseUrl("https://random.dog/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DogApiService::class.java)

    suspend fun obtenerPerroRemoto(): DogResponse = api.obtenerPerro()
}