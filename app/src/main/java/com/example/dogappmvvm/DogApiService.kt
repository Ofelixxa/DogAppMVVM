package com.example.dogappmvvm

import retrofit2.http.GET

interface DogApiService {
    @GET("woof.json")
    suspend fun obtenerPerro(): DogResponse
}