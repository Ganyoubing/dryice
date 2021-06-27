package com.example.dryice.request


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import kotlinx.serialization.Serializable

/**
 *
 * @author Gan YouBing
 * @date 2021/6/11 1:05
 * @desc 实体类
 *
 **/
//
//@Serializable
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
data class NewsRequest(
    val id : Int,
    val title: String,
    val summary: String,
    val date: String,
    val imageUrl: String,
)


