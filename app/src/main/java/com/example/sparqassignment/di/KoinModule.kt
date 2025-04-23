package com.example.sparqassignment.di

import com.example.sparqassignment.data.ItemRepository
import com.example.sparqassignment.data.remote.ItemApiService
import com.example.sparqassignment.ui.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/lanestp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ItemApiService> {
        get<Retrofit>().create(ItemApiService::class.java)
    }

    single { ItemRepository(get()) }

    viewModel { ListViewModel(get()) }
}
