package com.example.kotlin.examenmovil.framework.views.activities

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examenmovil.R
import com.example.kotlin.examenmovil.data.network.models.dbz.CharacterObject
import com.example.kotlin.examenmovil.databinding.ActivityMainBinding
import com.example.kotlin.examenmovil.data.network.models.dbz.CharacterBase
import com.example.kotlin.examenmovil.data.repositories.CharacterRepository
import com.example.kotlin.examenmovil.framework.adapters.CharacterAdapter
import com.example.kotlin.examenmovil.framework.viewmodel.MainViewModel
import com.example.kotlin.examenmovil.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(){

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private val adapter : CharacterAdapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        setUpFilterDropDown()
//        getCharacterList()
        initializeObservers()
        setUpFilterButton()

        viewModel.getCharacterList()

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


    private fun initializeObservers(){
        viewModel.characterObjectLiveData.observe(this){ characterObject ->
            setUpRecyclerView(characterObject.items)
        }
    }

    private fun setUpFilterDropDown(){
        val filterDropdown = binding.DropDownAffi
        val afiliations = resources.getStringArray(R.array.afiliations)
        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down_item, afiliations)
        filterDropdown.setAdapter(arrayAdapter)

    }

    private fun setUpFilterButton(){
        val button = binding.BFiltro

        button.setOnClickListener{
            val string = binding.DropDownAffi.text.toString()
            Log.d("Hola", string)
            viewModel.affiliationFilter(string)
        }
    }

}