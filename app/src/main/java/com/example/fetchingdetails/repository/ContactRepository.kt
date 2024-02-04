package com.example.fetchingdetails.repository

import com.example.fetchingdetails.model.Contact
import com.example.fetchingdetails.repository.api.ContactService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ContactRepository(val contactService: ContactService) {
    private var _contactList = MutableStateFlow<MutableList<Contact>>(mutableListOf())
    val contactsList: StateFlow<List<Contact>>
        get() = _contactList

    suspend fun addContact() {
        val contact = contactService.getContact().body()!!
        val currentContactList = _contactList.value.toMutableList()
        currentContactList.add(contact)
        _contactList.value = currentContactList
    }
    suspend fun removeContact(contact: Contact){
        val currentContactList = _contactList.value.toMutableList()
        currentContactList.removeAll(listOf(contact))
        _contactList.value = currentContactList
    }
}