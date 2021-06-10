package com.example.dryice.entities

import com.example.dryice.tables.News
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

/**
 *
 * @author Gan YouBing
 * @date 2021/6/11 2:35
 * @desc
 *
 **/
class News(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<com.example.dryice.entities.News>(News)

    var title by News.title
    var summary by News.summary
    var date by News.date
    var imageUrl by News.imageUrl
    var content by News.content
    var editor by News.editor


}