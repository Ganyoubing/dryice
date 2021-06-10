package com.example.dryice.response

import com.sun.xml.internal.ws.developer.Serialization
import org.jetbrains.kotlin.com.google.gson.annotations.SerializedName


@Serialization
data class NewsResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("editor")
    val editor: String
)