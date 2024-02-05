package com.example.fetchingdetails.repository.api

import com.example.fetchingdetails.model.Contact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ContactRepository(private val contactService: ContactService) {
    private var _contactList = MutableStateFlow<MutableList<Contact>>(mutableListOf())
    val contactsList: StateFlow<List<Contact>>
        get() = _contactList

    suspend fun addContact(): Contact {
        val contact = contactService.getContact().body()!!
        val currentContactList = _contactList.value.toMutableList()
        currentContactList.add(contact)
        _contactList.value = currentContactList
        return contact
    }
    fun addDBDatabase(contactLists: List<Contact>){
        _contactList.value= contactLists.toMutableList()
    }
    suspend fun removeContact(contact: Contact){
        val currentContactList = _contactList.value.toMutableList()
        currentContactList.removeAll(listOf(contact))
        _contactList.value = currentContactList
    }
}