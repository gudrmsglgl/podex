package com.example.network.model

import kotlinx.serialization.Serializable


@Serializable
data class NetworkPokemon(
    val name: String,
    val url: String
)