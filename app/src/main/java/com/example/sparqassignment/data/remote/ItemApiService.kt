package com.example.sparqassignment.data.remote

import com.example.sparqassignment.data.model.Item
import retrofit2.http.GET

interface ItemApiService {
    @GET("challenge-for-ios/refs/heads/main/test.json")
    suspend fun getItems(): List<Item>
}
