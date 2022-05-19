package com.osovan.mypokedex.data.network

import com.osovan.mypokedex.core.Retrofithelper
import com.osovan.mypokedex.data.model.PokemonModel
import com.osovan.mypokedex.data.model.PokemonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonService {


     private val retrofit = Retrofithelper.getRetrofit()

     suspend fun getPokemonList(): List<PokemonResult> {
          return withContext(Dispatchers.IO) {
               val response = retrofit.create(PokemonApiClient::class.java).getPokemonList(100, 0)
               response.body()?.results ?: emptyList()
          }
     }

     suspend fun getPokemonInfo(pokemonName: String): PokemonModel {
          return withContext(Dispatchers.IO) {
               val response = retrofit.create(PokemonApiClient::class.java).getPokemonInfo(pokemonName)
               response.body()!!
          }
     }
}