package com.osovan.mypokedex.data.network

import com.osovan.mypokedex.data.model.PokemonResult

class PokemonProvider {
     companion object {
          var pokemons: List<PokemonResult> = emptyList()
     }
}