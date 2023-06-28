package com.smarthome.shitemservice.dto

data class UpdateItemRequest(
    val name: String,
    val description: String,
    val characteristics: String,
    val imageUrl: String,
    val instructionUrl: String,
)

