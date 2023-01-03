package com.example.data.model

import com.example.network.model.NetworkPokemon

data class PokemonEntity(
    val name: String,
    val url: String
)

fun NetworkPokemon.asEntity() = PokemonEntity(
    name = this.name,
    url = this.url
)