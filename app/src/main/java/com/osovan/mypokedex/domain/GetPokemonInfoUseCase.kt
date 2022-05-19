package com.osovan.mypokedex.domain

import com.osovan.mypokedex.data.model.PokemonModel
import com.osovan.mypokedex.data.network.PokemonRepository

class GetPokemonInfoUseCase {

     private val repository = PokemonRepository()

     suspend operator fun invoke(pokemonName: String): PokemonModel? = repository.getPokemonInfo(pokemonName)

}