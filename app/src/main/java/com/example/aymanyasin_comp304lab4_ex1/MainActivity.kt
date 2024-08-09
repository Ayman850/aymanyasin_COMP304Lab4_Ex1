package com.example.aymanyasin_comp304lab4_ex1

import LandmarkTypeAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager


class MainActivity : AppCompatActivity() {

    private val landmarkTypes = LandmarkTypeDataSource.landmarkTypes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // in this activity i made landmark adapter reference
        val adp = LandmarkTypeAdapter(landmarkTypes) { position ->
            val selectedType = landmarkTypes[position]
        }

        // over here i made sure this make sure it is in 2 columns

        val rv = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)
        rv.layoutManager = GridLayoutManager(this@MainActivity, 2)
        rv.adapter = adp
    }
}
