package com.example.fetchingdetails.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fetchingdetails.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(
            getString(R.string.AboutFragmentLifeCycle),
            "${getString(R.string.onCreate)}   ${Thread.currentThread().name}"
        )
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

     override fun onCreateView(
         inflater: LayoutInflater, container: ViewGroup?,
         savedInstanceState: Bundle?
    ): View? {
         Log.d(
             getString(R.string.AboutFragmentLifeCycle),
             "${getString(R.string.onViewCreated)}   ${Thread.currentThread().name}"
         )
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.about_fragment, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AboutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(
            getString(R.string.AboutFragmentLifeCycle),
            "${getString(R.string.onAttach)}   ${Thread.currentThread().name}"
        )
    }


    override fun onStart() {
        super.onStart()
        Log.d(
            getString(R.string.AboutFragmentLifeCycle),
            "${getString(R.string.onStart)}   ${Thread.currentThread().name}"
        )
    }

    override fun onResume() {
        super.onResume()
        Log.d(
            getString(R.string.AboutFragmentLifeCycle),
            "${getString(R.string.onResume)}   ${Thread.currentThread().name}"
        )
    }

    override fun onPause() {
        super.onPause()
        Log.d(
            getString(R.string.AboutFragmentLifeCycle),
            "${getString(R.string.onPause)}   ${Thread.currentThread().name}"
        )
    }

    override fun onStop() {
        super.onStop()
        Log.d(
            getString(R.string.AboutFragmentLifeCycle),
            "${getString(R.string.onStop)}   ${Thread.currentThread().name}"
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(
            getString(R.string.AboutFragmentLifeCycle),
            "${getString(R.string.onDestroyView)}   ${Thread.currentThread().name}"
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(
            getString(R.string.AboutFragmentLifeCycle),
            "${getString(R.string.onDestroy)}   ${Thread.currentThread().name}"
        )
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(
            getString(R.string.AboutFragmentLifeCycle),
            "${getString(R.string.onDetach)}   ${Thread.currentThread().name}"
        )
    }

}