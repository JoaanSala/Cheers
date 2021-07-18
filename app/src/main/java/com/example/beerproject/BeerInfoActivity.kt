package com.example.beerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BeerInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beerinfo)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_beerInfo, BeerInfoFragment()).commit()
    }
}