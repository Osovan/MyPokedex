package com.osovan.mypokedex.data.network

import com.osovan.mypokedex.data.model.PokemonModel
import com.osovan.mypokedex.data.model.PokemonResult

class PokemonRepository {
     private val api = PokemonService()

     suspend fun getPokemonList(): List<PokemonResult> {
          val response = api.getPokemonList()
          PokemonProvider.pokemons = response
          return response
     }

     suspend fun getPokemonInfo(pokemonName: String): PokemonModel {
          return api.getPokemonInfo(pokemonName)
     }
}