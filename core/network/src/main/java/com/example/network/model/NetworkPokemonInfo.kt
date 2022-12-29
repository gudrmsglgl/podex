package com.example.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPokemonInfo(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    @SerialName("base_experience")
    val experience: Int,
    @SerialName("types")
    val types: List<TypeResponse>
)

@Serializable
data class TypeResponse(
    val slot: Int,
    val type: Type
)

@Serializable
data class Type(
    val name: String
)

