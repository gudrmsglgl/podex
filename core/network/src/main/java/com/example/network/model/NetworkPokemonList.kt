package com.example.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPokemonList(
    val count: Int,
    val next: String,
    val previous: String,
    @SerialName("results")
    val results: List<NetworkPokemon>
)