package com.example.kotlin.examenmovil.data.repositories

import com.example.kotlin.examenmovil.data.network.models.dbz.CharacterBase
import com.example.kotlin.examenmovil.data.network.models.dbz.CharacterObject
import com.example.kotlin.examenmovil.data.network.character.CharacterApiService
import com.example.kotlin.examenmovil.data.network.character.CharacterApiClient
import com.example.kotlin.examenmovil.data.network.character.NetworkModuleDI


class CharacterRepository {
    private val apiCharacter = CharacterApiClient()

    suspend fun getCharacterList(page:Int): CharacterObject? = apiCharacter.getCharacterList(page)

    suspend fun getCharacterInfoByName(name: String): CharacterBase?  = apiCharacter.getCharacterInfoByName(name)

    suspend fun getCharacterInfoByID(id: Int): CharacterBase?  = apiCharacter.getCharacterInfoById(id)
}

