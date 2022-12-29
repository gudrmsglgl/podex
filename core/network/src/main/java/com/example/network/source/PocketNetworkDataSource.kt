package com.example.network.source

import com.example.network.model.NetworkPokemonInfo
import com.example.network.model.NetworkPokemonList

interface PocketNetworkDataSource {
    suspend fun getPokemonList(limit: Int, offset: Int): NetworkPokemonList
    suspend fun getPokemonInfo(name: String): NetworkPokemonInfo
}