package com.example.ahmedtw_1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Massage_table")
data class Massage(
    @PrimaryKey(autoGenerate = true)
    var massageId:Int,
    var imageId: Int,
    val name: String,
    var massage: String
)
