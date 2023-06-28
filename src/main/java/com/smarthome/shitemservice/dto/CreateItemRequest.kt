package com.smarthome.shitemservice.dto

data class CreateItemRequest(
    val ownerId: String,
    val name: String,
    val description: String,
    val characteristics: String,
    val imageUrl: String,
    val instructionUrl: String,
)
