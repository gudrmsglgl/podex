package com.example.domain.model

import com.example.data.model.PokemonEntity

data class Pokemon(
    val name: String,
    val url: String
)

fun PokemonEntity.asDomain() = Pokemon(
    name = this.name,
    url = this.url
)