package com.example.fetchingdetails.repository.api

import com.example.fetchingdetails.model.Contact
import retrofit2.Response
import retrofit2.http.GET

interface ContactService {
    @GET("api/users/random_user")
    suspend fun getContact() : Response<Contact>
}