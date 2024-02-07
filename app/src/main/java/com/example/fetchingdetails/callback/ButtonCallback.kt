package com.example.fetchingdetails.callback

import com.example.fetchingdetails.model.Contact

 interface ButtonCallback {
    fun onButtonClickAdd(contact: Contact)
    fun onButtonClickDelete(fragmentTag: String)
}