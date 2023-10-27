package com.example.ahmedtw_1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ahmedtw_1.Constants.DATABASE_NAME
import com.example.ahmedtw_1.models.Message

@Database(entities = [Message::class], version = 1, exportSchema = true)
abstract class UserDataBase : RoomDatabase() {

    abstract fun messagesDAO(): MessagesDAO

    companion object {
        @Volatile
        private var instance: UserDataBase? = null

        fun getInstance(context: Context): UserDataBase {
            return instance ?: synchronized(Any()) {
                buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): UserDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                UserDataBase::class.java,
                DATABASE_NAME
            ).fallbackToDestructiveMigration().build()
        }
    }
}