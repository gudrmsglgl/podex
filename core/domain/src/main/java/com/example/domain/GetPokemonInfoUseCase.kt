package com.example.domain

import com.example.data.repository.PodexRepository
import com.example.domain.model.PokemonInfo
import com.example.domain.model.asDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPokemonInfoUseCase
@Inject
constructor(private val repository: PodexRepository) {
    operator fun invoke(name: String): Flow<PokemonInfo> {
        return repository.getPokemonInfo(name)
            .map {
                it.asDomain()
            }
    }
}