package com.example.dryice.request


import java.util.*
import io.ktor.jackson.*
import com.fasterxml.jackson.databind.*

/**
 *
 * @author Gan YouBing
 * @date 2021/6/11 1:05
 * @desc 实体类
 *
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
data class NewsRequest(
    val id : Int,
    val title: String,
    val summary: String,
    val date: Date,
    val imageUrl: String,
)


