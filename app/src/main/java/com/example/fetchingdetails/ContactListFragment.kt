import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fetchingdetails.ButtonCallback
import com.example.fetchingdetails.R
import com.example.fetchingdetails.repository.api.ContactApi
import com.example.fetchingdetails.repository.api.ContactApiRepository
import com.example.fetchingdetails.repository.api.RetrofitHelper
import com.example.fetchingdetails.repository.roomDatabase.ContactRoomDatabase
import com.example.fetchingdetails.view.FirstPage
import com.example.fetchingdetails.viewModel.ContactViewModel
import com.example.fetchingdetails.viewModel.ContactViewModelFactory

class ContactListFragment(private val callback: ButtonCallback) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        Log.d(getString(R.string.ContactListFragmentLifeCycle), "${getString(R.string.onCreateView)}   ${Thread.currentThread().name}")
        // Create a ComposeView and return it
        return ComposeView(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(getString(R.string.ContactListFragmentLifeCycle), "${getString(R.string.onViewCreated)}   ${Thread.currentThread().name}")
        super.onViewCreated(view, savedInstanceState)
        setupCompose(view as ComposeView)
    }


    private fun setupCompose(composeView: ComposeView) {
        val contactApi = RetrofitHelper.getInstance().create(ContactApi::class.java)
        val contactApiRepository = ContactApiRepository(contactApi)
        val contactRoomDatabase: ContactRoomDatabase =
            ContactRoomDatabase.getInstance(requireContext())
        var viewModel: ContactViewModel = ViewModelProvider(
            this,
            ContactViewModelFactory(contactApiRepository, contactRoomDatabase)
        ).get(ContactViewModel::class.java)
        composeView.setContent {
            FirstPage(viewModel, callback)
        }
    }



    override fun onAttach(context: Context) {
        Log.d(getString(R.string.ContactListFragmentLifeCycle), "${getString(R.string.onAttach)}   ${Thread.currentThread().name}")
        super.onAttach(context)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(getString(R.string.ContactListFragmentLifeCycle), "${getString(R.string.onCreate)}   ${Thread.currentThread().name}")
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        Log.d(getString(R.string.ContactListFragmentLifeCycle), "${getString(R.string.onStart)}   ${Thread.currentThread().name}")
        super.onStart()

    }

    override fun onResume() {
        Log.d(getString(R.string.ContactListFragmentLifeCycle), "${getString(R.string.onResume)}   ${Thread.currentThread().name}")
        super.onResume()

    }

    override fun onPause() {
        Log.d(getString(R.string.ContactListFragmentLifeCycle), "${getString(R.string.onPause)}   ${Thread.currentThread().name}")
        super.onPause()

    }

    override fun onStop() {
        Log.d(getString(R.string.ContactListFragmentLifeCycle), "${getString(R.string.onStop)}   ${Thread.currentThread().name}")
        super.onStop()

    }

    override fun onDestroyView() {
        Log.d(getString(R.string.ContactListFragmentLifeCycle), "${getString(R.string.onDestroyView)}   ${Thread.currentThread().name}")
        super.onDestroyView()

    }

    override fun onDestroy() {
        Log.d(getString(R.string.ContactListFragmentLifeCycle), "${getString(R.string.onDestroy)}   ${Thread.currentThread().name}")
        super.onDestroy()

    }

    override fun onDetach() {
        Log.d(getString(R.string.ContactListFragmentLifeCycle), "${getString(R.string.onDetach)}   ${Thread.currentThread().name}")
        super.onDetach()

    }

}
