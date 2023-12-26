package com.example.typeconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.typeconverter.model.UserAddress
import com.example.typeconverter.repository.Db
import com.example.typeconverter.repository.UserEntity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userAddress = UserAddress("54", "asdasd", "tuzla", "istanbul", "turkey")
        val userAddress2 = UserAddress("14", "qweqwe", "maltepe", "istanbul", "turkey")

        val database = Db.getDatabase(this)
        database?.database()?.insert(value = UserEntity(id = null, "Rasim", 54, "asd@gmail.com", userAddress))
        database?.database()?.insert(value = UserEntity(id = null, "Mehmet", 14, "qwe@gmail.com", userAddress2))
        database?.database()?.getAllEntries().apply { this?.forEach { entity ->
                println("name::${entity.name} address::${entity.address}")
            }
        }
    }
}