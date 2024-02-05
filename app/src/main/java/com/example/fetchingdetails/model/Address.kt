package com.example.fetchingdetails.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("address_table")
data class Address(
    @PrimaryKey(autoGenerate = true)
    val address_id:Int,
    val city: String,
    @Embedded
    val coordinates: Coordinates,
    val country: String,
    val state: String,
    val street_address: String,
    val street_name: String,
    val zip_code: String
)