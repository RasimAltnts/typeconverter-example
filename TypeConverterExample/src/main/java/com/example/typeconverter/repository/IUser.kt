package com.example.typeconverter.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IUser {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(value: UserEntity)

    @Query("SELECT * FROM UserDB")
    fun getAllEntries(): List<UserEntity>

}