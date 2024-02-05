package com.example.fetchingdetails.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("contact_table")
data class Contact(
    @Embedded
    val address: Address,
    val avatar: String,
    @Embedded
    val credit_card: CreditCard,
    val date_of_birth: String,
    val email: String,
    @Embedded
    val employment: Employment,
    val first_name: String,
    val gender: String,
    @PrimaryKey
    val id: Int,
    val last_name: String,
    val password: String,
    val phone_number: String,
    val social_insurance_number: String,
    @Embedded
    val subscription: Subscription,
    val uid: String,
    val username: String
)