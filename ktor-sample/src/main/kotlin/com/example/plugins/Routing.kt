package com.example.plugins




import com.example.dryice.entities.News
import com.example.dryice.request.NewsRequest
import com.example.dryice.response.NewsResponse
import io.ktor.routing.*

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*

import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import jdk.nashorn.internal.ir.debug.JSONWriter
import org.h2.util.json.JSONString
import org.h2.util.json.JSONValue
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils


import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.kotlin.com.google.gson.Gson


fun Application.configureRouting() {
    val user = "ekuaibao"
    val password = "ZQQEnz4MA9AdPHkbgVWWHY"
    Database.connect(user = user,//连接数据库
        password = password,
        url = "jdbc:mysql://192.168.1.129:3306/ekbX1",
        driver = "com.mysql.cj.jdbc.Driver")
    transaction {
        SchemaUtils.create(com.example.dryice.tables.News)
    }

    // Starting point for a Ktor app:
    routing {


        static("static") {
            resource("static")
        }

        get("/") {
            call.respondText("Hello World!")
        }

        get("/news") {
            val newsList = transaction {
                News.all()
                    .sortedByDescending { it.id }.map {
                        NewsResponse(
                            id = it.id.value,
                            title = it.title,
                            summary = it.summary,
                            date = it.date.toString(),
                            imageUrl = it.imageUrl,
                            content = it.content,
                            editor = it.editor
                        )
                    }.toList()
            }
            call.respond(newsList.toString())
        }

        post("/news") {
            val newsRequest = call.receive<NewsRequest>()
            val response = transaction {
                News.findById(newsRequest.id)?.let {
                    NewsResponse(
                        id = it.id.value,
                        title = it.title,
                        summary = it.summary,
                        date = it.date.toString(),
                        imageUrl = it.imageUrl,
                        content = it.content,
                        editor = it.editor
                    )
                }
            }
            if (response != null) {
                call.respond(newsRequest)
            } else {
                call.respond(HttpStatusCode.NotFound,"Not found this record")
            }

        }



    }
}


