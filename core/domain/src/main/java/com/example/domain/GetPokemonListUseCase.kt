package com.example.domain

import com.example.data.repository.PodexRepository
import com.example.domain.model.PokemonList
import com.example.domain.model.asDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPokemonListUseCase
@Inject constructor(private val podexRepository: PodexRepository) {
    operator fun invoke(limit: Int, offset: Int) : Flow<PokemonList> {
        return podexRepository.getPokemonList(limit, offset)
            .map {
                it.asDomain()
            }
    }

}