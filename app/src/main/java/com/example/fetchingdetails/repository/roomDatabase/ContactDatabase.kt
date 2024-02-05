package com.example.fetchingdetails.repository.roomDatabase

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fetchingdetails.model.Contact


@Database(entities = [ Contact::class ], version = 1)
abstract class ContactDatabase(): RoomDatabase(){

    fun printDatabasePath(context: Context) {
        val dbPath: String = context.getDatabasePath("contact_DB").absolutePath
        Log.d("Database Path", dbPath)
    }
    abstract fun contactDao(): ContactDao
    suspend fun getContacts():List<Contact>{
        return contactDao().getContact()
    }
    suspend fun removeContact(contact:Contact){
        contactDao().deleteContact(contact)
    }
    suspend fun addContact(contact:Contact){
        contactDao().addContact(contact)
    }
    companion object{
        @Volatile
        private var instance: ContactDatabase? =null
        fun getInstance(context: Context): ContactDatabase {
            synchronized(this) {
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, ContactDatabase::class.java, "contactDB")
                            .build()
                }
            }
            return instance!!
        }

    }
}