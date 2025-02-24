package com.jose.lopez.cryptobalance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_investments -> {
                    selectedFragment = InvestmentsFragment()
                }
                R.id.nav_exchanges -> {
                    selectedFragment = ExchangesFragment()
                }
                R.id.nav_cryptos -> {
                    selectedFragment = CryptosFragment()
                }
            }
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment).commit()
            }
            true
        }
        // Cargar el fragmento de inversiones por defecto
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, InvestmentsFragment()).commit()
    }
}
