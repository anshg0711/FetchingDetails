package com.example.fetchingdetails.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fetchingdetails.viewModel.DetailViewModel


@Composable
fun FirstPage(detailViewModel : DetailViewModel=viewModel()) {
    val detailsList by detailViewModel.detailsList.collectAsState()
    Column{
        OutlinedButton(onClick = { detailViewModel.addDetail() }) {
            Text(text = "Add")
        }
        Surface {
            Column(Modifier.verticalScroll(state = rememberScrollState())) {
                for (details in detailsList) {
                    ContactFaceCard(details)
                }
            }
        }
    }

}