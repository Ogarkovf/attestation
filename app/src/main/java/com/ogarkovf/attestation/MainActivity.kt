package com.ogarkovf.attestation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM="item"
private val DICE_ROLL_FRAGMENT=DiceRollFragment().javaClass.name
private val ABOUT_FRAGMENT=AboutFragment().javaClass.name

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView=findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.dice_roll -> {
                    fragment=DiceRollFragment()
                }
                R.id.about -> {
                    fragment=AboutFragment()
                }
            }
            replaceFragment(fragment!!)
            true
        }

        bottomNavigationView.selectedItemId=
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.dice_roll
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM,bottomNavigationView.selectedItemId)

        val currentFragment=supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(
            outState,
            currentFragment.javaClass.name,
            currentFragment
        )

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
    }
}