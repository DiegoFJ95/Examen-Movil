package com.example.kotlin.examenmovil.data.models.dbz

import com.example.kotlin.examenmovil.data.models.dbz.classes.Item
import com.example.kotlin.examenmovil.data.models.dbz.classes.Links
import com.example.kotlin.examenmovil.data.models.dbz.classes.Meta
import com.google.gson.annotations.SerializedName


data class Character(
    @SerializedName("items") val items: ArrayList<Item>,
    @SerializedName("links") val links: Links,
    @SerializedName("meta") val meta: Meta
)
