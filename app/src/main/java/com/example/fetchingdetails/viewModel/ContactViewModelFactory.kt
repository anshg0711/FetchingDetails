package com.example.fetchingdetails.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fetchingdetails.repository.api.ContactApiRepository
import com.example.fetchingdetails.repository.roomDatabase.ContactDatabase

class ContactViewModelFactory(private val contactApiRepository: ContactApiRepository, private val contactDatabase: ContactDatabase):ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            return ContactViewModel(contactApiRepository, contactDatabase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

