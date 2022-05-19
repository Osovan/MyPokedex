package com.osovan.mypokedex.ui.mainList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osovan.mypokedex.data.model.PokemonResult
import com.osovan.mypokedex.data.network.PokemonProvider
import com.osovan.mypokedex.domain.GetPokemonListUseCase
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

     val pokemons = MutableLiveData<List<PokemonResult>>()
     val isLoading = MutableLiveData<Boolean>()
     var getPokemonListUseCase = GetPokemonListUseCase()

     fun getPokemonList() {
          val pokemonList = PokemonProvider.pokemons
          Log.d("Oscar", "pokemonList: ${pokemonList.toString()}")
          pokemons.postValue(pokemonList)
     }

     fun onCreate() {
          viewModelScope.launch {
               isLoading.postValue(true)
               val result = getPokemonListUseCase()
               if (!result.isNullOrEmpty()) {
                    pokemons.postValue(result)
                    isLoading.postValue(false)
               }

          }
     }
}