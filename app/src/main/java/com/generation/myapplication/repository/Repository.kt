package com.generation.myapplication.repository

import com.generation.myapplication.api.RetrofitInstance
import com.generation.myapplication.model.Categoria
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>>{
        return RetrofitInstance.api.ListCategoria()
    }

}