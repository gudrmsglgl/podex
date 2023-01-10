package com.example.domain.model

import com.example.data.model.PokemonInfoEntity
import com.example.data.model.TypeEntity
import com.example.data.model.TypeResponseEntity

data class PokemonInfo(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
    val types: List<TypeResponse>
)

data class TypeResponse(
    val slot: Int,
    val type: Type
)

data class Type(
    val name: String
)

fun PokemonInfoEntity.asDomain() = PokemonInfo(
    id = this.id,
    name = this.name,
    height = this.height,
    weight = this.weight,
    experience = this.experience,
    types = this.types.map { it.asDomain() }
)

fun TypeResponseEntity.asDomain() = TypeResponse(
    slot = this.slot,
    type = this.type.asDomain()
)


fun TypeEntity.asDomain() = Type(
    name = this.name
)
