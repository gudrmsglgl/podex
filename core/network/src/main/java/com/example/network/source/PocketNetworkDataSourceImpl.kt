package com.example.network.source

import com.example.network.model.NetworkPokemonInfo
import com.example.network.model.NetworkPokemonList
import com.example.network.retrofit.PocketApi
import javax.inject.Inject

class PocketNetworkDataSourceImpl
@Inject constructor(private val api: PocketApi) : PocketNetworkDataSource {

    override suspend fun getPokemonList(limit: Int, offset: Int): NetworkPokemonList {
        return api.getPokemonList(limit, offset)
    }

    override suspend fun getPokemonInfo(name: String): NetworkPokemonInfo {
        return api.getPokemonInfo(name)
    }
}