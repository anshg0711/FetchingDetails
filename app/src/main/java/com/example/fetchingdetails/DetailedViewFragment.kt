package com.example.fetchingdetails

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.fetchingdetails.model.Contact
import com.example.fetchingdetails.view.DetailedContactView

class DetailedViewFragment(private val contact: Contact, private val callback: ButtonCallback) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(getString(R.string.DetailViewFragmentLifeCycle), "${getString(R.string.onCreateView)}   ${Thread.currentThread().name}")
        // Create a ComposeView and return it
        return ComposeView(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        Log.d(getString(R.string.DetailViewFragmentLifeCycle), "${getString(R.string.onViewCreated)}   ${Thread.currentThread().name}")
        setupCompose(view as ComposeView)
    }



    private fun setupCompose(composeView: ComposeView) {

        composeView.setContent {
            DetailedContactView(contact = contact) { callback.onButtonClickDelete("DetailedViewFragment") }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(getString(R.string.DetailViewFragmentLifeCycle), "${getString(R.string.onAttach)}   ${Thread.currentThread().name}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(getString(R.string.DetailViewFragmentLifeCycle), "${getString(R.string.onCreate)}   ${Thread.currentThread().name}")
    }

    override fun onStart() {
        super.onStart()
        Log.d(getString(R.string.DetailViewFragmentLifeCycle), "${getString(R.string.onStart)}   ${Thread.currentThread().name}")
    }

    override fun onResume() {
        super.onResume()
        Log.d(getString(R.string.DetailViewFragmentLifeCycle), "${getString(R.string.onResume)}   ${Thread.currentThread().name}")
    }

    override fun onPause() {
        super.onPause()
        Log.d(getString(R.string.DetailViewFragmentLifeCycle), "${getString(R.string.onPause)}   ${Thread.currentThread().name}")
    }

    override fun onStop() {
        super.onStop()
        Log.d(getString(R.string.DetailViewFragmentLifeCycle), "${getString(R.string.onStop)}   ${Thread.currentThread().name}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(getString(R.string.DetailViewFragmentLifeCycle), "${getString(R.string.onDestroyView)}   ${Thread.currentThread().name}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(getString(R.string.DetailViewFragmentLifeCycle), "${getString(R.string.onDestroy)}   ${Thread.currentThread().name}")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(getString(R.string.DetailViewFragmentLifeCycle), "${getString(R.string.onDetach)}   ${Thread.currentThread().name}")
    }

}

