package com.example.kotlin.examenmovil.domain

import com.example.kotlin.examenmovil.data.network.models.dbz.CharacterBase
import com.example.kotlin.examenmovil.data.repositories.CharacterRepository

class CharacterInfoRequirement {

    private val repository = CharacterRepository()

    suspend operator fun invoke(
        name:String
    ): CharacterBase? = repository.getCharacterInfoByName(name)
}
