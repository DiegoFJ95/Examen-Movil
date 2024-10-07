package com.example.kotlin.examenmovil.data.network.models.dbz

import com.example.kotlin.examenmovil.data.network.models.dbz.classes.Item
import com.example.kotlin.examenmovil.data.network.models.dbz.classes.Links
import com.example.kotlin.examenmovil.data.network.models.dbz.classes.Meta
import com.google.gson.annotations.SerializedName


data class Character(
    @SerializedName("items") val items: ArrayList<Item>,
    @SerializedName("links") val links: Links,
    @SerializedName("meta") val meta: Meta
)
