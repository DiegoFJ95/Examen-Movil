package com.example.kotlin.examenmovil.framework.viewholders

import android.content.Context
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.examenmovil.data.models.dbz.CharacterBase
import com.example.kotlin.examenmovil.data.repositories.CharacterRepository
import com.example.kotlin.examenmovil.databinding.ItemCharacterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CharacterBase ,context:Context){
        binding.TVName.text = item.name
        binding.TVAffiliation.text = item.affiliation
        binding.TVGender.text = item.gender
        binding.TVKi.text = item.ki
        binding.TVRace.text = item.race
//        getCharacterInfo(item.image,binding.IVPhoto,context)
        CoroutineScope(Dispatchers.Main).launch {

            val urlImage = item.image.toString()


            val requestOptions =  RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .priority(Priority.HIGH)

            Glide.with(context).load(urlImage)
                .apply(requestOptions)
                .into(binding.IVPhoto)

        }
    }

//    private fun getCharacterInfo(url: String, imageView: ImageView, context: Context){
//
//        var characterStringNumber:String = url.replace("https://dragonball-api.com/api/characters/","")
//        characterStringNumber = characterStringNumber.replace("/","")
//        val name:Int = Integer.parseInt(characterStringNumber)
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val characterRepository = CharacterRepository()
//            val result: CharacterBase? = characterRepository.getCharacterInfo(characterStringNumber)
//            CoroutineScope(Dispatchers.Main).launch {
//
//                val urlImage = result?.image.toString()
//                Log.d("SalidaFoto", urlImage)
//
//
//                val requestOptions =  RequestOptions()
//                    .centerCrop()
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .fitCenter()
//                    .priority(Priority.HIGH)
//
//                Glide.with(context).load(urlImage)
//                    .apply(requestOptions)
//                    .into(imageView)
//            }
//        }}
}

