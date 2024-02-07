package com.example.fetchingdetails



import ContactListFragment
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fetchingdetails.model.Contact

class XmlActivity : AppCompatActivity(), ButtonCallback {

    private val fragmentManager = supportFragmentManager
    private lateinit var contactListFragment: ContactListFragment
    private val aboutFragment= AboutFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        contactListFragment = ContactListFragment(this)
        setContentView(R.layout.activity_xml)

        showFragment(contactListFragment, "contactListFragment")
        findViewById<Button>(R.id.button).setOnClickListener {
            onButtonClickDelete("DetailedViewFragment")
            showFragment(contactListFragment, "contactListFragment")
        }

        findViewById<Button>(R.id.buttonC).setOnClickListener {
            onButtonClickDelete("DetailedViewFragment")
            showFragment(aboutFragment, "aboutFragment")
        }
    }


    private fun showFragment(fragment: Fragment, fragmentTag: String ) {
        val transaction = fragmentManager.beginTransaction()
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
        showFragment(DetailedViewFragment(contact, this), "DetailedViewFragment")
    }

    override fun onButtonClickDelete(fragmentTag: String) {
        val fragment=fragmentManager.findFragmentByTag(fragmentTag)
        fragment?.let {
            supportFragmentManager.beginTransaction().remove(it).commit()
        }
        if(fragmentTag == "DetailedViewFragment"){
            showFragment(contactListFragment, "contactListFragment")
        }
    }
}
