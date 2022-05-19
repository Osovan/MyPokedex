package com.osovan.mypokedex.data.network

import com.osovan.mypokedex.data.model.PokemonModel
import com.osovan.mypokedex.data.model.PokemonApiModel
import com.osovan.mypokedex.data.model.PokemonResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiClient {
     @GET("pokemon")
     suspend fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Response<PokemonApiModel>
     @GET("pokemon/{name}")
     suspend fun getPokemonInfo(@Path("name") name: String): Response<PokemonModel>

}