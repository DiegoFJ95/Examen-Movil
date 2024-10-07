package com.example.kotlin.examenmovil.domain

import com.example.kotlin.examenmovil.data.network.models.dbz.CharacterObject
import com.example.kotlin.examenmovil.data.repositories.CharacterRepository

class CharacterListRequirement {

    private val repository = CharacterRepository()

    suspend operator fun invoke(
        page:Int
    ): CharacterObject? = repository.getCharacterList(page)

}