package com.osovan.mypokedex.ui.mainList

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.osovan.mypokedex.data.model.PokemonResult
import com.osovan.mypokedex.data.network.PokemonProvider
import com.osovan.mypokedex.databinding.ActivityListBinding
import com.osovan.mypokedex.ui.detail.DetailActivity

class ListActivity : AppCompatActivity() {

     private val viewModel: ListViewModel by viewModels()
     private lateinit var binding: ActivityListBinding

     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          binding = ActivityListBinding.inflate(layoutInflater)
          setContentView(binding.root)
          initUI()
     }

     private fun initUI() {
          binding.rvPokemons.layoutManager = GridLayoutManager(this, 2)
          viewModel.onCreate()
          viewModel.pokemons.observe(this, Observer {
               binding.rvPokemons.adapter = ListAdapter(PokemonProvider.pokemons) { onPokemonSelected(it) }

          })

          viewModel.isLoading.observe(this, Observer {
               binding.pbProgress.isVisible = it
          })
     }

     private fun onPokemonSelected(pokemonList: PokemonResult) {
          val intent = Intent(this, DetailActivity::class.java)
          intent.putExtra("name", pokemonList.name)
          startActivity(intent)
     }
}