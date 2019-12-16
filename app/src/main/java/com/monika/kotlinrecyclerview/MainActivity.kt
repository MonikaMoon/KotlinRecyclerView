package com.monika.kotlinrecyclerview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.monika.kotlinrecyclerview.fragments.FactsListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setting toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            //setHomeAsUpIndicator(R.mipmap.baseline_menu_white_18dp)
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        navigation_view.setNavigationItemSelectedListener(this)

        displayScreen(-1)

        val kotlinFragment = FactsListFragment.newInstance(getString(R.string.home))
        supportFragmentManager.beginTransaction()
            .replace(R.id.relative_layout, kotlinFragment, FactsListFragment.javaClass.name).commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun displayScreen(id: Int) {
        when (id) {
            R.id.action_home -> {
                toast(getString(R.string.home))
                val kotlinFragment = FactsListFragment.newInstance(getString(R.string.home))
                supportFragmentManager.beginTransaction()
                    .replace(R.id.relative_layout, kotlinFragment, FactsListFragment.javaClass.name)
                    .commit()
            }

            R.id.action_description -> {
                toast(getString(R.string.home))
            }

            R.id.action_setting -> {
                toast(getString(R.string.home))
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        displayScreen(item.itemId)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    // Extension function to show toast message easily
    private fun Context.toast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}