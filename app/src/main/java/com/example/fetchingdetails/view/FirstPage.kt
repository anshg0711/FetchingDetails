package com.example.fetchingdetails.view

import com.example.fetchingdetails.ButtonCallback
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.fetchingdetails.viewModel.ContactViewModel


@Composable
fun FirstPage(contactViewModel: ContactViewModel, callback: ButtonCallback) {
    val contactsList by contactViewModel.contactList.collectAsState()
    Column {
        OutlinedButton(colors = ButtonDefaults.outlinedButtonColors(
            Color.Cyan
        ), onClick = { contactViewModel.addContact() }) {
            Text(text = "Add", fontStyle = FontStyle.Italic)
        }

        Surface(Modifier.weight(.9F)) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
                    .padding(vertical = 10.dp, horizontal = 5.dp)
                    .verticalScroll(state = rememberScrollState())
            ) {

                for (contact in contactsList) {

                    ContactFaceCard(
                        contact, contactViewModel, callback
                    )
                }

            }
        }
    }

}