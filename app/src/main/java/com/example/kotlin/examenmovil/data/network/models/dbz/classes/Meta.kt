package com.example.kotlin.examenmovil.data.network.models.dbz.classes

data class Meta(
    val currentPage: Int,
    val itemCount: Int,
    val itemsPerPage: Int,
    val totalItems: Int,
    val totalPages: Int
)