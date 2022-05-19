package com.osovan.mypokedex.ui.mainList

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.osovan.mypokedex.data.model.PokemonResult
import com.osovan.mypokedex.data.model.PokemonApiModel
import com.osovan.mypokedex.databinding.PokemonItemBinding

class ListAdapter(
     private val pokemonList: List<PokemonResult>,
     private val onClickListener: (PokemonResult) -> Unit
) : RecyclerView.Adapter<ListAdapter.PokemonViewHolder>() {


     override fun onCreateViewHolder(
          parent: ViewGroup,
          viewType: Int
     ): ListAdapter.PokemonViewHolder {
          val binding =
               PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
          return PokemonViewHolder(binding)
     }

     override fun onBindViewHolder(holder: ListAdapter.PokemonViewHolder, position: Int) {
          val item = pokemonList[position]
          holder.render(item, position+1, onClickListener)
     }

     override fun getItemCount() = pokemonList.size

     class PokemonViewHolder(private val binding: PokemonItemBinding) :
          RecyclerView.ViewHolder(binding.root) {

          fun render(pokemon: PokemonResult, index: Int, onClickListener: (PokemonResult) -> Unit) {
               val formattedNumber = index.toString().padStart(3, '0')
               val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"

               Glide.with(itemView.context).load(imageUrl).into(binding.ivPokemon)
               binding.tvPokemonName.text = pokemon.name
               itemView.setOnClickListener { onClickListener(pokemon) }

          }
     }


}