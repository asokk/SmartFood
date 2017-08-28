package com.github.ramonrabello.smartfood

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.github.ramonrabello.smartfood.promo.PromoFragment
import com.github.ramonrabello.smartfood.shoppingcart.ShoppingCartFragment
import com.github.ramonrabello.smartfood.snacks.SnacksFragment
import kotlinx.android.synthetic.main.activity_main.*
/**
 * Main activity
 */
class MainActivity : AppCompatActivity() {

    private val WRITE_EXTERNAL_STORAGE_PERMISSION: Int = 0

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    showSnacksFragment()
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
        })
    }

    private fun showSnacksFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_content, SnacksFragment.newInstance()).addToBackStack(null).commit()
        toolbar.setTitle(R.string.title_home)
    }

    override fun onResume() {
        super.onResume()
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), WRITE_EXTERNAL_STORAGE_PERMISSION)
        } else {
            showSnacksFragment()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode){
            WRITE_EXTERNAL_STORAGE_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    showSnacksFragment()
                }
            }
        }
    }
}