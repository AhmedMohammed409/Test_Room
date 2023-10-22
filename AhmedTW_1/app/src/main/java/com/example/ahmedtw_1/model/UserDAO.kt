package com.example.ahmedtw_1.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDAO {
    @Insert
     suspend fun addMassage(massage: Massage)
    @Delete
    suspend fun deleteMassage(massage:Massage)
    @Query("select *from Massage_table")
     fun getAllMassage():List<Massage>

}