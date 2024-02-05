package com.example.fetchingdetails.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fetchingdetails.repository.api.ContactRepository
import com.example.fetchingdetails.repository.roomDatabase.ContactDatabase

class ContactViewModelFactory(private val contactRepository: ContactRepository, private val contactDatabase: ContactDatabase):ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            return ContactViewModel(contactRepository, contactDatabase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

