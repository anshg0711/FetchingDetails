package com.example.fetchingdetails.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.fetchingdetails.model.Address
import com.example.fetchingdetails.model.Contact
import com.example.fetchingdetails.model.Coordinates
import com.example.fetchingdetails.model.CreditCard
import com.example.fetchingdetails.model.Employment
import com.example.fetchingdetails.model.Subscription


@Composable
fun DetailedContactView (contact:Contact, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
    ) {
        Column(Modifier.padding(10.dp)) {
            IconButton(
                onClick = onClick,
                modifier = Modifier.align(Alignment.End)
                    .size(88.dp)
                    .padding(8.dp)
                    .wrapContentSize()
            ) {
                Icon(
                    modifier = Modifier.size(78.dp),
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.Black
                )
            }
            Row(Modifier.padding(vertical = 10.dp)) {
                Image(
                    painter = rememberImagePainter(data = contact.avatar),
                    contentDescription = "image of the avatar", modifier = Modifier
                        .size(135.dp)
                        .weight(.6F)
                        .clip(MaterialTheme.shapes.medium)
                )

            }
            Row {
                Text(
                    fontSize = 20.sp,modifier = Modifier.weight(1F),
                    fontWeight = FontWeight(1000),
                    text = "FirstName: "
                )
                Text(fontSize = 20.sp,modifier = Modifier.weight(1F), text = "${contact.first_name}  ")
            }
            Row {
                Text(
                    fontSize = 20.sp,modifier = Modifier.weight(1F),
                    fontWeight = FontWeight(1000),
                    text = "LastName: "
                )
                Text(fontSize = 20.sp,modifier = Modifier.weight(1F), text = "${contact.last_name}  ")
            }
            Row {
                Text(
                    fontSize = 20.sp,modifier = Modifier.weight(1F),
                    fontWeight = FontWeight(1000),
                    text = "Phone Number: "
                )
                Text(fontSize = 20.sp,modifier = Modifier.weight(1F), text = "${contact.phone_number}  ")
            }
            Row {
                Text(
                    fontSize = 20.sp,modifier = Modifier.weight(1F),
                    fontWeight = FontWeight(1000),
                    text = "Date of birth: "
                )
                Text(fontSize = 20.sp,modifier = Modifier.weight(1F), text = "${contact.date_of_birth}  ")
            }
            Row {
                Text(
                    fontSize = 20.sp,modifier = Modifier.weight(1F),
                    fontWeight = FontWeight(1000),
                    text = "Email: "
                )
                Text(fontSize = 20.sp,modifier = Modifier.weight(1F), text = "${contact.email}  ")
            }
            Row {
                Text(
                    fontSize = 20.sp,modifier = Modifier.weight(1F),
                    fontWeight = FontWeight(1000),
                    text = "City/Country: "
                )
                Text(
                    fontSize = 20.sp,modifier = Modifier.weight(1F),
                    text = "${contact.address.city}/${contact.address.country}"
                )
            }


        }
    }
}
@Preview
@Composable
fun DetailedContactViewPreview() {
    val testContact = Contact(
        address = Address(
            address_id = 123,
            city = "Test City",
            coordinates = Coordinates(
                lat = 123.456,
                lng = 456.789
            ),
            country = "Test Country",
            state = "Test State",
            street_address = "123 Test Street",
            street_name = "Test Street",
            zip_code = "12345"
        ),
        avatar = "https://example.com/avatar.jpg",
        credit_card = CreditCard(
            cc_number = "1234 5678 9012 3456"
        ),
        date_of_birth = "2000-01-01",
        email = "test@example.com",
        employment = Employment(
            key_skill = "Test Skill",
            title = "Test Title"
        ),
        first_name = "Test",
        gender = "Male",
        id = 1,
        last_name = "Contact",
        password = "password",
        phone_number = "123-456-7890",
        social_insurance_number = "123-456-789",
        subscription = Subscription(
            payment_method = "Credit Card",
            plan = "Premium",
            status = "Active",
            term = "Monthly"
        ),
        uid = "abcdef123456",
        username = "testuser"
    )


    DetailedContactView(contact = testContact, onClick = {})
}