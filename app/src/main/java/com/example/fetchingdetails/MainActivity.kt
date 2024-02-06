package com.example.fetchingdetails

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.fetchingdetails.repository.api.ContactApi
import com.example.fetchingdetails.repository.api.RetrofitHelper
import com.example.fetchingdetails.repository.api.ContactApiRepository
import com.example.fetchingdetails.repository.roomDatabase.ContactRoomDatabase
import com.example.fetchingdetails.ui.theme.FetchingDetailsTheme
import com.example.fetchingdetails.view.FirstPage
import com.example.fetchingdetails.viewModel.ContactViewModel
import com.example.fetchingdetails.viewModel.ContactViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: ContactViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(getString(R.string.LifeCycle), getString(R.string.onCreate))
         val contactApi= RetrofitHelper.getInstance().create(ContactApi::class.java)
         val contactApiRepository= ContactApiRepository(contactApi)
         val contactRoomDatabase:ContactRoomDatabase = ContactRoomDatabase.getInstance(applicationContext)
        Log.d("RoomDatabase path",contactRoomDatabase.printDatabasePath(applicationContext).toString())

        viewModel = ViewModelProvider(this, ContactViewModelFactory(contactApiRepository,contactRoomDatabase)).get(ContactViewModel::class.java)
        setContent {
            FetchingDetailsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    FirstPage(contactViewModel = viewModel)
                }
            }

        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(getString(R.string.LifeCycle), getString(R.string.onStart))
    }

    override fun onResume() {
        super.onResume()
        Log.d(getString(R.string.LifeCycle), getString(R.string.onResume))
    }

    override fun onPause() {
        super.onPause()
        Log.d(getString(R.string.LifeCycle), getString(R.string.onPause))
    }

    override fun onStop() {
        super.onStop()
        Log.d(getString(R.string.LifeCycle), getString(R.string.onStop))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(getString(R.string.LifeCycle), getString(R.string.onDestroy))
    }

}

