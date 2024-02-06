package com.example.fetchingdetails.view

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
import coil.compose.rememberImagePainter
import com.example.fetchingdetails.model.Contact
import com.example.fetchingdetails.viewModel.ContactViewModel


@Composable
fun ContactFaceCard(contact: Contact,contactViewModel: ContactViewModel) {
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
                        .size(135.dp).weight(.6F)
                        .clip(MaterialTheme.shapes.medium)
                )
                Button(modifier = Modifier.weight(.4F),onClick = { contactViewModel.removeContact(contact) }) {
                    Text(text = "Erase")
                }

            }
            Row {
                Text(
                    modifier = Modifier.weight(1F),
                    fontWeight = FontWeight(1000),
                    text = "FirstName: "
                )
                Text(modifier = Modifier.weight(1F), text = "${contact.first_name}  ")
            }
            Row {
                Text(
                    modifier = Modifier.weight(1F),
                    fontWeight = FontWeight(1000),
                    text = "LastName: "
                )
                Text(modifier = Modifier.weight(1F), text = "${contact.last_name}  ")
            }
            Row {
                Text(
                    modifier = Modifier.weight(1F),
                    fontWeight = FontWeight(1000),
                    text = "Phone Number: "
                )
                Text(modifier = Modifier.weight(1F), text = "${contact.phone_number}  ")
            }
            Row {
                Text(
                    modifier = Modifier.weight(1F),
                    fontWeight = FontWeight(1000),
                    text = "Date of birth: "
                )
                Text(modifier = Modifier.weight(1F), text = "${contact.date_of_birth}  ")
            }
            Row {
                Text(
                    modifier = Modifier.weight(1F),
                    fontWeight = FontWeight(1000),
                    text = "Email: "
                )
                Text(modifier = Modifier.weight(1F), text = "${contact.email}  ")
            }
            Row {
                Text(
                    modifier = Modifier.weight(1F),
                    fontWeight = FontWeight(1000),
                    text = "City/Country: "
                )
                Text(
                    modifier = Modifier.weight(1F),
                    text = "${contact.address.city}/${contact.address.country}"
                )
            }


        }
    }
}
