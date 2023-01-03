package com.example.data.repository

import com.example.data.model.PokemonInfoEntity
import com.example.data.model.PokemonListEntity
import kotlinx.coroutines.flow.Flow

interface PodexRepository {
    fun getPokemonList(limit: Int, offset: Int): Flow<PokemonListEntity>
    fun getPokemonInfo(name: String): Flow<PokemonInfoEntity>
}