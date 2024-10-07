package com.example.kotlin.examenmovil.framework.viewmodel

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kotlin.examenmovil.data.models.dbz.CharacterBase
import com.example.kotlin.examenmovil.databinding.ItemCharacterBinding

import com.example.kotlin.examenmovil.framework.viewholders.CharacterViewHolder

class CharacterAdapter: RecyclerView.Adapter<CharacterViewHolder>() {

    var data:ArrayList<CharacterBase> = ArrayList()
    lateinit var context: Context

    fun CharacterAdapter(basicData : ArrayList<CharacterBase>,context:Context){
        this.data = basicData
        this.context = context
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item,context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
