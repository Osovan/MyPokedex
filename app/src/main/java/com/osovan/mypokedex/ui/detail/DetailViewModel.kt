package com.osovan.mypokedex.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osovan.mypokedex.data.model.PokemonModel
import com.osovan.mypokedex.data.network.PokemonService
import kotlinx.coroutines.launch

class DetailViewModel(): ViewModel() {

     val pokemonInfo = MutableLiveData<PokemonModel>()

     fun getPokemonInfo(namePokemon: String) {
          viewModelScope.launch {
               val pokemonList = PokemonService().getPokemonInfo(namePokemon)
               pokemonInfo.postValue(pokemonList)
          }
     }

}