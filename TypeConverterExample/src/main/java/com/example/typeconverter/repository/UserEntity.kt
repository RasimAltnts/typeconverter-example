package com.example.typeconverter.repository

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.typeconverter.model.UserAddress
import com.google.gson.Gson

@androidx.room.Entity(tableName = "UserDB")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int? = 0,
    @ColumnInfo(name ="name") var name: String?,
    @ColumnInfo(name = "number") var number: Int?,
    @ColumnInfo(name = "email") var email: String?,
    @ColumnInfo(name = "address") var address: UserAddress?
) {
}

class UserTypeConverter() {

    @TypeConverter
    fun fromUserModel(value: UserAddress): String = Gson().toJson(value)

    @TypeConverter
    fun toUserModel(value: String): UserAddress = Gson().fromJson(value,UserAddress::class.java)
}
