package com.example.fetchingdetails.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchingdetails.model.Contact
import com.example.fetchingdetails.repository.api.ContactRepository
import com.example.fetchingdetails.repository.roomDatabase.ContactDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch




class ContactViewModel(private val contactRepository: ContactRepository, private val contactDatabase: ContactDatabase): ViewModel()

{

    val contactList: StateFlow<List<Contact>> get()=contactRepository.contactsList
    fun addContact(){
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("IO thread from addContact ", Thread.currentThread().name)

           val contact= contactRepository.addContact()
            contactDatabase.addContact(contact)
        }
    }
    fun removeContact(contact: Contact){
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("IO thread from removeContact ", Thread.currentThread().name)
            contactRepository.removeContact(contact)
            contactDatabase.removeContact(contact)
        }
    }
    init{
        viewModelScope.launch {
            val contactLists = contactDatabase.getContacts()
            contactRepository.addDBDatabase(contactLists)
        }

    }

}