package com.example.data.repository

import android.util.Log
import com.example.common.dispatcher.InjectionDispatcher
import com.example.common.dispatcher.PodexDispatchers
import com.example.data.model.PokemonInfoEntity
import com.example.data.model.PokemonListEntity
import com.example.data.model.asEntity
import com.example.network.source.PocketNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PodexRepositoryImpl
@Inject constructor(
    private val pocketNetworkSource: PocketNetworkDataSource,
    @InjectionDispatcher(PodexDispatchers.IO) private val dispatcher: CoroutineDispatcher
) : PodexRepository {
    override fun getPokemonList(limit: Int, offset: Int): Flow<PokemonListEntity> = flow {
        val networkPokemonList = pocketNetworkSource.getPokemonList(limit, offset)
        emit(networkPokemonList.asEntity())
    }.flowOn(dispatcher)

    override fun getPokemonInfo(name: String): Flow<PokemonInfoEntity> = flow {
        val networkPokemonInfo = pocketNetworkSource.getPokemonInfo(name)
        emit(networkPokemonInfo.asEntity())
    }.flowOn(dispatcher)

}