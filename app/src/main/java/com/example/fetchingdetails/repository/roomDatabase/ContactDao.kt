package com.example.fetchingdetails.repository.roomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.fetchingdetails.model.Contact


@Dao
interface ContactDao {
    @Insert
    suspend fun addContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("Select * from contact_table")
    suspend fun getContact():List<Contact>


}