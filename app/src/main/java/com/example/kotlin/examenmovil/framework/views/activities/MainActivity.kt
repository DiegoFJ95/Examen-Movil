package com.example.kotlin.examenmovil.framework.views.activities

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examenmovil.data.models.dbz.CharacterObject
import com.example.kotlin.examenmovil.databinding.ActivityMainBinding
import com.example.kotlin.examenmovil.data.models.dbz.CharacterBase
import com.example.kotlin.examenmovil.data.repositories.CharacterRepository
import com.example.kotlin.examenmovil.framework.viewmodel.CharacterAdapter
import com.example.kotlin.examenmovil.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : Activity(){

    private lateinit var binding: ActivityMainBinding
    private val adapter : CharacterAdapter = CharacterAdapter()
//    private lateinit var data:ArrayList<CharacterBase>
//
//    private fun testData():ArrayList<CharacterBase>{
//        var result = ArrayList<CharacterBase>()
//
////        result.add(CharacterBase("Goku",""))
////        result.add(CharacterBase("Vegetta",""))
////        result.add(CharacterBase("Krilin",""))
//
//        return result
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        getCharacterList()

    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    private fun setUpRecyclerView(dataForList:ArrayList<CharacterBase>){
        val rvcharacter = binding.RVCharacter
        rvcharacter.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        rvcharacter.layoutManager = linearLayoutManager
        adapter.CharacterAdapter(dataForList, this)
        rvcharacter.adapter = adapter
    }

    private fun getCharacterList(){
        CoroutineScope(Dispatchers.IO).launch {
            val characterRepository = CharacterRepository()
            val result: CharacterObject? = characterRepository.getCharacterList(Constants.PAGE)
            CoroutineScope(Dispatchers.Main).launch {
                setUpRecyclerView(result?.items!!)
            }

        }

    }


}