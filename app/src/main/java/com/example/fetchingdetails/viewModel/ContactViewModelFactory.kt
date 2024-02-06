package com.example.fetchingdetails.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fetchingdetails.repository.api.ContactApiRepository
import com.example.fetchingdetails.repository.roomDatabase.ContactRoomDatabase

@Suppress("UNCHECKED_CAST IN ContactViewModelFactory")
class ContactViewModelFactory(private val contactApiRepository: ContactApiRepository, private val contactRoomDatabase: ContactRoomDatabase):ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            return ContactViewModel(contactApiRepository, contactRoomDatabase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

