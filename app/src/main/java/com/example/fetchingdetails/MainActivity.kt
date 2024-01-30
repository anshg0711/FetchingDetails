package com.example.fetchingdetails

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fetchingdetails.ui.theme.FetchingDetailsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(getString(R.string.LifeCycle), getString(R.string.onCreate))

        setContent {
            FetchingDetailsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(text = "ansh")
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

