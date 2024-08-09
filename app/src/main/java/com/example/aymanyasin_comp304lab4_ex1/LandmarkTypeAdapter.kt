import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.aymanyasin_comp304lab4_ex1.LandmarkListActivity
import com.example.aymanyasin_comp304lab4_ex1.LandmarkType
import com.example.aymanyasin_comp304lab4_ex1.R

class LandmarkTypeAdapter(private val types: List<LandmarkType>, private val onItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<LandmarkTypeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgLandmarkType: ImageView = itemView.findViewById(R.id.imgLandmarkType)
        val btnLandmarkType: Button = itemView.findViewById(R.id.btnLandmarkType)
    }


    // this is helping getting the size of the types
    override fun getItemCount(): Int = types.size


    override fun onCreateViewHolder(p: ViewGroup, vt: Int): ViewHolder {
        val v = LayoutInflater.from(p.context).inflate(R.layout.landmark_type_item, p, false)
        return ViewHolder(v)
    }


    // this is done based on professor lecture
    override fun onBindViewHolder(customholder: ViewHolder, postn: Int) {
        val typeLandmarks = types[postn]
        customholder.imgLandmarkType.setImageResource(typeLandmarks.imageRes)
        customholder.btnLandmarkType.text = typeLandmarks.name
        customholder.btnLandmarkType.setOnClickListener {
            onItemClick(postn)
            val context = it.context
            val intent = Intent(context, LandmarkListActivity::class.java)
            intent.putExtra("landmarkType", typeLandmarks.name)
            context.startActivity(intent)
        }
    }


}




