package com.example.fetchingdetails.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchingdetails.model.Contact
import com.example.fetchingdetails.repository.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class ContactViewModel( val contactRepository: ContactRepository): ViewModel() {
    val contactList: StateFlow<List<Contact>> get()=contactRepository.contactsList
    fun addContact(){
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("IO thread from addContact ", Thread.currentThread().name)
            contactRepository.addContact()
        }
    }
    fun removeContact(contact: Contact){
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("IO thread from removeContact ", Thread.currentThread().name)
            contactRepository.removeContact(contact)
        }
    }

}