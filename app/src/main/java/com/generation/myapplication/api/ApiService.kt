package com.generation.myapplication.api

import com.generation.myapplication.model.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("categoria")
    fun ListCategoria(): Response<List<Categoria>>
}