package com.example.sparqassignment.data

import com.example.sparqassignment.data.model.Item
import com.example.sparqassignment.data.remote.ItemApiService

class ItemRepository(private val apiService: ItemApiService) {
    suspend fun getItems(): List<Item> = apiService.getItems()
}
