package com.example.kotlin.examenmovil.data.network.character

import com.example.kotlin.examenmovil.data.network.models.dbz.CharacterBase
import com.example.kotlin.examenmovil.data.network.models.dbz.CharacterObject
import com.example.kotlin.examenmovil.data.network.character.CharacterApiService
import com.example.kotlin.examenmovil.data.network.character.NetworkModuleDI


class CharacterApiClient {
    private lateinit var api:CharacterApiService

    suspend fun getCharacterList(page:Int): CharacterObject?{
        api = NetworkModuleDI()
        return try{
            api.getCharacterList(page, 58)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }

    }

    suspend fun getCharacterInfoById(id:Int): CharacterBase? {
        api = NetworkModuleDI()
        return try{
            api.getCharacterInfoById(id)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getCharacterInfoByName(name: String): CharacterBase? {
        api = NetworkModuleDI()
        return try{
            api.getCharacterInfoByName(name)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}