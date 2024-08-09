package com.example.aymanyasin_comp304lab4_ex1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LandmarkAdapter(private val landmarks: List<Landmark>, private val onItemClick2: (Int) -> Unit) :
    RecyclerView.Adapter<LandmarkAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnLandmarkType: ImageView = itemView.findViewById(R.id.imgLandmark)
        val textLandmarkType: TextView = itemView.findViewById(R.id.textLandmark)
    }


    override fun getItemCount(): Int = landmarks.size

// over here  am inflating the recycler view to use
    override fun onCreateViewHolder(p: ViewGroup, vT: Int): ViewHolder {
        val v = LayoutInflater
                        .from(p.context)
                        .inflate(R.layout
                            .landmark_item, p, false)

        return ViewHolder(v)
    }


    // my custom view holder is holding the information nd on click functionality

    override fun onBindViewHolder(customholder: ViewHolder, postn: Int) {
        val landmark = landmarks[postn]

        customholder.btnLandmarkType.setImageResource(landmark.imageRes)
        customholder.textLandmarkType.text = landmark.name
        customholder.btnLandmarkType.setOnClickListener {
            onItemClick2(postn)

            val context = it.context
            val intent = Intent(context, MapsActivity::class.java)
            intent.putExtra("landmarkName", landmark.name)
            context.startActivity(intent)
        }
    }


}