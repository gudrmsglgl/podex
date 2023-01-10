package com.example.domain.model

import com.example.data.model.PokemonEntity
import com.example.data.model.PokemonListEntity
import com.example.data.model.asEntity

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Pokemon>
)

fun PokemonListEntity.asDomain() = PokemonList(
    count = this.count,
    next = this.next,
    previous = this.previous,
    results = this.results.map {
        it.asDomain()
    }
)
