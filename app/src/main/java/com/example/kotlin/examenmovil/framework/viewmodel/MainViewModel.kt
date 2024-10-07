package com.example.kotlin.examenmovil.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.examenmovil.data.network.models.dbz.CharacterObject
import com.example.kotlin.examenmovil.data.network.models.dbz.CharacterBase
import com.example.kotlin.examenmovil.data.repositories.CharacterRepository
import com.example.kotlin.examenmovil.domain.CharacterListRequirement
import com.example.kotlin.examenmovil.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val characterObjectLiveData = MutableLiveData<CharacterObject>()
    private val characterListRequirement = CharacterListRequirement()
    private lateinit var data:ArrayList<CharacterBase>


    fun getCharacterList(){
        viewModelScope.launch(Dispatchers.IO) {
            val result: CharacterObject? = characterListRequirement(Constants.PAGE)
            result?.let{

                characterObjectLiveData.postValue(it)

                data = it.items
            }
//            Log.d("Salida", result?.items.toString())
//            CoroutineScope(Dispatchers.Main).launch {
//            }
        }
    }


    fun affiliationFilter(afiliation: String) {
        val results = data.filter { afiliation == it.affiliation }
        characterObjectLiveData.postValue(CharacterObject(ArrayList(results)))
    }



}