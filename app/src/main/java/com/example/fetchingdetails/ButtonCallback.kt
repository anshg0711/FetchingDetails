package com.example.fetchingdetails

import com.example.fetchingdetails.model.Contact

 interface ButtonCallback {
    fun onButtonClickAdd(contact: Contact)
    fun onButtonClickDelete(fragmentTag: String)
}