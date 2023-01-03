package com.example.data.model

import com.example.network.model.NetworkPokemonList

data class PokemonListEntity(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonEntity>
)

fun NetworkPokemonList.asEntity() = PokemonListEntity(
    count = this.count,
    next = this.next,
    previous = this.previous,
    results = this.results.map {
        it.asEntity()
    }
)