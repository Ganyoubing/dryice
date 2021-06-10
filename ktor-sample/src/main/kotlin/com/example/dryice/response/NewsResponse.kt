package com.example.dryice.response

import io.ktor.jackson.*
import com.fasterxml.jackson.databind.*

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