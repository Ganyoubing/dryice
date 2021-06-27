package com.example.dryice.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class NewsResponse(
    val id: Int,
    val title: String,
    val summary: String,
    val date: String,
    val imageUrl: String,
    val content: String,
    val editor: String
)