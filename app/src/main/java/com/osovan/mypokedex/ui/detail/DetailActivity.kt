package com.osovan.mypokedex.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.osovan.mypokedex.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

     private val viewModel: DetailViewModel by viewModels()
     private lateinit var binding: ActivityDetailBinding

     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          binding = ActivityDetailBinding.inflate(layoutInflater)
          setContentView(binding.root)


          initUI()
     }

     private fun initUI() {
          val name = intent.extras?.get("name") as String


          viewModel.getPokemonInfo(name)
          viewModel.pokemonInfo.observe(this, Observer { pokemon ->
               binding.heightText.text = "Altura: ${pokemon.height * 10.0} centímetros"
               binding.weightText.text = "Peso: ${pokemon.weight / 10.0} Kgs"
               title = pokemon.name
               Glide
                    .with(binding.imageView.context)
                    .load(pokemon.sprites.other?.home?.frontDefault)
                    .into(binding.imageView)


          })
     }


}