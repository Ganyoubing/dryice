package com.example.dryice.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.`java-time`.datetime

/**
 *
 * @author Gan YouBing
 * @date 2021/6/11 0:39
 * @desc 申明一个table 创建一个表
 *
 **/
//注意这里是单例撞见
object News: IntIdTable() {
    val title = varchar("title", 255)
    val summary = varchar("summary", 500)
    val date = datetime("date")
    val imageUrl = varchar("imageUrl", 500)
    val content = text("content")
    val editor = varchar("editor",255)
}

