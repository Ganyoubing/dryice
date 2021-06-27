package com.example

import com.example.dryice.tables.News
import com.example.dryice.request.NewsRequest
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class ApplicationTest {
}

fun main(args: Array<String>) {

    val user = "ekuaibao"
    val password = "ZQQEnz4MA9AdPHkbgVWWHY"
    val db = Database.connect(user = user,//连接数据库
        password = password,
        url = "jdbc:mysql://192.168.1.129:3306/ekbX1",
        driver = "com.mysql.cj.jdbc.Driver")

    transaction {
        SchemaUtils.create(News)
        News.insert {

        }
    }
}