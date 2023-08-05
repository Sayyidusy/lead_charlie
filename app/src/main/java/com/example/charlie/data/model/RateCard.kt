package com.example.charlie.data.model

data class RateCard(
    val id : String? = null,
    val title : String? = null,
    val price : Int? = null,
    val desc : String? = null,
    val duration: Int? = null,
    val creator_name : String? = null,
    val available_dates : List<String>? = null,
    val available_times : List<String>? = null,
)
