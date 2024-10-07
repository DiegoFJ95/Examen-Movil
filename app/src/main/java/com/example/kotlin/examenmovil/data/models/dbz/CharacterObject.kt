package com.example.kotlin.examenmovil.data.models.dbz

import com.example.kotlin.examenmovil.data.models.dbz.CharacterBase
import com.example.kotlin.examenmovil.data.models.dbz.classes.Links
import com.example.kotlin.examenmovil.data.models.dbz.classes.Meta
import com.google.gson.annotations.SerializedName

data class CharacterObject(
    @SerializedName("items") val items: ArrayList<CharacterBase>,
    @SerializedName("links") val links: Links,
    @SerializedName("meta") val meta: Meta
)