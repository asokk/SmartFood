package com.github.ramonrabello.smartfood

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.github.ramonrabello.smartfood.promo.PromoFragment
import com.github.ramonrabello.smartfood.shoppingcart.ShoppingCartFragment
import com.github.ramonrabello.smartfood.snacks.SnacksFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.toolbar

/**
 * Main activity
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_content, SnacksFragment.newInstance()).addToBackStack(null).commit()
                    toolbar.setTitle(R.string.title_home)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_content, PromoFragment.newInstance()).addToBackStack(null).commit()
                    toolbar.setTitle(R.string.title_dashboard)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_content, ShoppingCartFragment.newInstance()).addToBackStack(null).commit()
                    toolbar.setTitle(R.string.title_notifications)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        });
    }
}