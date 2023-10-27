package com.example.ahmedtw_1.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Massage_table")
data class Message(
    val username: String,
    val message: String,
    @PrimaryKey(autoGenerate = true)
    var massageId: Int? = null
)
