package com.example.typeconverter.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [UserEntity::class], version = 1, exportSchema = true)
@TypeConverters(UserTypeConverter::class)
abstract class Db: RoomDatabase() {
    abstract fun database(): IUser
    companion object {
        private var instace: Db ?= null
        fun getDatabase(context: Context): Db? {
            if (instace == null) {
                instace = Room.databaseBuilder(context, Db::class.java, "UserDB").allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instace
        }
    }
}