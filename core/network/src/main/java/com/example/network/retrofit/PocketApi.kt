package com.example.network.retrofit

import com.example.network.model.NetworkPokemonInfo
import com.example.network.model.NetworkPokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PocketApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): NetworkPokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): NetworkPokemonInfo

}