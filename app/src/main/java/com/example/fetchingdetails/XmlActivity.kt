package com.example.fetchingdetails



import com.example.fetchingdetails.fragments.ContactListFragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fetchingdetails.callback.ButtonCallback
import com.example.fetchingdetails.fragments.AboutFragment
import com.example.fetchingdetails.fragments.DetailedViewFragment
import com.example.fetchingdetails.model.Contact

class XmlActivity : AppCompatActivity(), ButtonCallback {
    private var detailedViewFragmentOpen=false
    private val fragmentManager = supportFragmentManager
    private lateinit var contactListFragment: ContactListFragment
    private val aboutFragment= AboutFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        contactListFragment = ContactListFragment(this)
        setContentView(R.layout.activity_xml)

        showFragment(contactListFragment, "contactListFragment")
        findViewById<Button>(R.id.button).setOnClickListener {
            if(detailedViewFragmentOpen)
            onButtonClickDelete("DetailedViewFragment")
            showFragment(contactListFragment, "contactListFragment")
        }

        findViewById<Button>(R.id.buttonC).setOnClickListener {
            if(detailedViewFragmentOpen)
            onButtonClickDelete("DetailedViewFragment")
            showFragment(aboutFragment, "aboutFragment")
        }
    }


    @SuppressLint("ResourceType")
    private fun showFragment(fragment: Fragment, fragmentTag: String ) {
        val transaction = fragmentManager.beginTransaction()
        val enterAnimation = R.drawable.slide_in_right
        val exitAnimation = R.drawable.slide_out_left
        val popEnterAnimation = R.drawable.slide_in_left
        val popExitAnimation = R.drawable.slide_out_right

        transaction.setCustomAnimations(enterAnimation, exitAnimation, popEnterAnimation, popExitAnimation)
        if (!fragment.isAdded) {
            transaction.add(R.id.fragment_container, fragment, fragmentTag)
        }

        for (existingFragment in fragmentManager.fragments) {
            if (existingFragment != fragment) {
                transaction.hide(existingFragment)
            }
        }
        transaction.show(fragment)
        transaction.commit()
    }

    override fun onButtonClickAdd(contact: Contact) {
        detailedViewFragmentOpen=true
        showFragment(DetailedViewFragment(contact, this), "DetailedViewFragment")
    }

    override fun onButtonClickDelete(fragmentTag: String) {
        val fragment=fragmentManager.findFragmentByTag(fragmentTag)
        fragment?.let {
            supportFragmentManager.beginTransaction().remove(it).commit()
        }
        if(fragmentTag == "DetailedViewFragment"){
            detailedViewFragmentOpen=false
            showFragment(contactListFragment, "contactListFragment")
        }
    }
}
