package com.example.ahmedtw_1.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATABASE_NAME="user_database"
@Database(entities = [Massage::class], version = 1, exportSchema = true)
abstract class UserDataBase:RoomDatabase() {
    abstract fun userdao(): UserDAO
    companion object{
        @Volatile
        private var instance:UserDataBase?=null
        fun getinstance(context: Context):UserDataBase{
            return instance?: synchronized(Any()){ buildDatabase(context).also{ instance=it}
            }
        }

        private fun buildDatabase(context: Context): UserDataBase {
            return Room.databaseBuilder(context.applicationContext,UserDataBase::class.java,
                DATABASE_NAME).fallbackToDestructiveMigration().build()
        }
    }
}