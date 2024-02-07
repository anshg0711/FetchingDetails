package com.example.fetchingdetails.view

import com.example.fetchingdetails.callback.ButtonCallback
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.fetchingdetails.model.Contact
import com.example.fetchingdetails.viewModel.ContactViewModel


@Composable
fun ContactFaceCard(contact: Contact,contactViewModel: ContactViewModel, callback: ButtonCallback) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
    ) {
        Column {
            Row(Modifier.padding(10.dp)) {


                Image(
                    painter = rememberImagePainter(data = contact.avatar),
                    contentDescription = "image of the avatar", modifier = Modifier
                        .size(135.dp)
                        .weight(.6F)
                        .clip(MaterialTheme.shapes.medium)
                )
                Column(Modifier.weight(.4F)) {
                    Button(modifier = Modifier.fillMaxSize(), onClick = {
                        contactViewModel.removeContact(contact)

                    }) {
                        Text(text = "Delete")
                    }

                    Button(modifier = Modifier.fillMaxSize(), onClick = {

                        callback.onButtonClickAdd(contact)
                    }) {
                        Text(text = "Open")
                    }
                }
            }
            Text(text = "")

            Row(Modifier.padding(horizontal = 10.dp)) {
                Text(
                    modifier = Modifier.weight(1F),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(1000),
                    text = "FirstName: "
                )

                Text(modifier = Modifier.weight(1F),
                    fontSize = 20.sp,
                    text = "${contact.first_name}  ")
            }

            Row (Modifier.padding(horizontal = 10.dp)){
                Text(
                    modifier = Modifier.weight(1F),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(1000),
                    text = "LastName: "
                )
                Text(modifier = Modifier.weight(1F),
                    fontSize = 20.sp,
                    text = "${contact.last_name}  ")
            }
            Text(text = "")



        }
    }
}

