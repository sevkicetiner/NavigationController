package com.example.navigationcontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navigation:NavController
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerlayout)
        navigation = this.findNavController(R.id.myNavContHost)
        NavigationUI.setupActionBarWithNavController(this,navigation, drawerLayout)
        var navigationView:NavigationView = findViewById(R.id.navView)
        NavigationUI.setupWithNavController(navigationView,navigation)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navigation,drawerLayout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.actionbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,navigation) || super.onOptionsItemSelected(item)
    }
}
