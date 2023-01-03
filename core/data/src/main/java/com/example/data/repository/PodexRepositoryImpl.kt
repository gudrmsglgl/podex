package com.example.data.repository

import com.example.data.model.PokemonInfoEntity
import com.example.data.model.PokemonListEntity
import com.example.data.model.asEntity
import com.example.network.source.PocketNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PodexRepositoryImpl
@Inject constructor(
    private val pocketNetworkSource: PocketNetworkDataSource
) : PodexRepository {
    override fun getPokemonList(limit: Int, offset: Int): Flow<PokemonListEntity> = flow {
        val networkPokemonList = pocketNetworkSource.getPokemonList(limit, offset)
        emit(networkPokemonList.asEntity())
    }

    override fun getPokemonInfo(name: String): Flow<PokemonInfoEntity> = flow {
        val networkPokemonInfo = pocketNetworkSource.getPokemonInfo(name)
        emit(networkPokemonInfo.asEntity())
    }

}