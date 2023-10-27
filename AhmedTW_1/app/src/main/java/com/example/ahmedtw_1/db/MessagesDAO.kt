package com.example.ahmedtw_1.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.ahmedtw_1.models.Message

@Dao
interface MessagesDAO {
    @Insert
    suspend fun addMassage(message: Message)

    @Delete
    suspend fun deleteMassage(message: Message)

    @Query("select *from Massage_table")
    fun getAllMassages(): List<Message>
}