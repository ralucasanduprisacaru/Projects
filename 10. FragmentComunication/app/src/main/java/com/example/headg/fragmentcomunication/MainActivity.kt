package com.example.headg.fragmentcomunication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewFragment.OnPersonSelectedListener {
private lateinit var recyclerViewFragment: RecyclerViewFragment
    private lateinit var itemFragment : ItemFragment
    private val RECYCLER_VIEW_FRAGMENT_TAG = "rvFragment"
    private val ITEM_FRAGMENT_TAG = "itemFragment"


    override fun onPersonSelected(person: Person) {
        val fragment: ItemFragment = supportFragmentManager.findFragmentByTag(ITEM_FRAGMENT_TAG) as ItemFragment
        fragment.personSelected(person)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    recyclerViewFragment = RecyclerViewFragment()
        itemFragment = ItemFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.rvFragmentContainer, recyclerViewFragment, RECYCLER_VIEW_FRAGMENT_TAG)
                .add(R.id.itemFragmentContainer,itemFragment, ITEM_FRAGMENT_TAG )
                .commit()
    }


}
