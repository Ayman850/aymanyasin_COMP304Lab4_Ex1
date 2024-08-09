package com.example.aymanyasin_comp304lab4_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aymanyasin_comp304lab4_ex1.LandmarkTypeDataSource.landmarkTypes

class LandmarkListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmark_list)

        val landmarkType = intent.getStringExtra("landmarkType")


        val landmark = landmarkTypes.find { it.name == landmarkType }
        if (landmark != null) {
            val adpt = LandmarkAdapter( landmark.landmarks, onItemClick2 = { position ->

            })
            val rv = findViewById<RecyclerView>(R.id.recyclerViewListLandmark)
            rv.layoutManager = LinearLayoutManager(this@LandmarkListActivity)
            rv.adapter = adpt
        }

        // my this button to go back to MainActivity
        val buttonBackToLandmarkType = findViewById<Button>(R.id.buttonBackToLandmarkType)
        buttonBackToLandmarkType.setOnClickListener {
            val intent = Intent(this@LandmarkListActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}


