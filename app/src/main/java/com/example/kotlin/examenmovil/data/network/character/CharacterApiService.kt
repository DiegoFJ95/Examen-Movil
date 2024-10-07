package com.example.kotlin.examenmovil.data.network.character

import com.example.kotlin.examenmovil.data.models.dbz.CharacterObject

import com.example.kotlin.examenmovil.data.models.dbz.CharacterBase


import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path

interface CharacterApiService {
    //https://dragonball-api.com/api/
    @GET("characters")
    suspend fun getCharacterList(
        @Query("page") page: Int,
    ): CharacterObject


    //https://dragonball-api.com/api/
    @GET("characters/{id}")
    suspend fun getCharacterInfoById(
        @Path("id") id: Int
    ): CharacterBase

    @GET("characters")
    suspend fun getCharacterInfoByName(
        @Query("name") name: String
    ): CharacterBase
}