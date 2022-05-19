package com.osovan.mypokedex.domain

import com.osovan.mypokedex.data.model.PokemonResult
import com.osovan.mypokedex.data.network.PokemonRepository

class GetPokemonListUseCase {

     private val repository = PokemonRepository()

     suspend operator fun invoke(): List<PokemonResult>? = repository.getPokemonList()

}