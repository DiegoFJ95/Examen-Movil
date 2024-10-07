package com.example.kotlin.examenmovil.data.network.models.dbz

import com.example.kotlin.examenmovil.data.network.models.dbz.CharacterBase
import com.example.kotlin.examenmovil.data.network.models.dbz.classes.Links
import com.example.kotlin.examenmovil.data.network.models.dbz.classes.Meta
import com.google.gson.annotations.SerializedName

data class CharacterObject(
    @SerializedName("items") val items: ArrayList<CharacterBase>,
)