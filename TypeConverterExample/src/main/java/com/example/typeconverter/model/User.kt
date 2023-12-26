package com.example.typeconverter.model

data class UserAddress(
    var number: String ?= null,
    var street: String ?= null,
    var district: String ?= null,
    var city: String ?= null,
    var country: String ?= null,
)