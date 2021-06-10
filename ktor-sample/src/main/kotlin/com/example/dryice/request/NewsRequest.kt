package com.example.dryice.request


import com.sun.xml.internal.ws.developer.Serialization
import org.jetbrains.kotlin.com.google.gson.annotations.SerializedName
import java.util.*


/**
 *
 * @author Gan YouBing
 * @date 2021/6/11 1:05
 * @desc 实体类
 *
 **/

data class NewsRequest(
    @SerializedName("id")
    val id : Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("date")
    val date: Date,
    @SerializedName("imageUrl")
    val imageUrl: String,
)


