package com.example.data.model

import com.example.network.model.NetworkPokemonInfo
import com.example.network.model.Type
import com.example.network.model.TypeResponse

data class PokemonInfoEntity(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
    val types: List<TypeResponseEntity>
)

data class TypeResponseEntity(
    val slot: Int,
    val type: TypeEntity
)

fun TypeResponse.asEntity() = TypeResponseEntity(
    slot = this.slot,
    type = this.type.asEntity()
)

data class TypeEntity(
    val name: String
)

fun Type.asEntity() = TypeEntity(
    name = this.name
)

fun NetworkPokemonInfo.asEntity() = PokemonInfoEntity(
    id = this.id,
    name = this.name,
    height = this.height,
    weight = this.weight,
    experience = this.experience,
    types = this.types.map {
        it.asEntity()
    }
)