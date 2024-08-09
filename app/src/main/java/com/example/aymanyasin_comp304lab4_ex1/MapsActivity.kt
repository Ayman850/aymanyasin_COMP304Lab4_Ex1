package com.example.aymanyasin_comp304lab4_ex1

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.example.aymanyasin_comp304lab4_ex1.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var marker: Marker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Show dialog to choose map view before proceeding
        showMapViewDialog()
    }

    // Function to show a dialog to choose between satellite view and normal map view
    private fun showMapViewDialog() {
        val mapViewOptions = arrayOf("Satellite View", "Normal Map View")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose Map View")
        builder.setItems(mapViewOptions) { dialog, which ->
            when (which) {
                0 -> {
                    // Satellite View selected
                    mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
                    proceedWithMapSetup()
                }
                1 -> {
                    // Normal Map View selected
                    mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                    proceedWithMapSetup()
                }
            }
            dialog.dismiss()
        }
        builder.show()
    }

    // Function to proceed with geocoding and adding marker after choosing map view
    private fun proceedWithMapSetup() {
        val coder = Geocoder(applicationContext)
        val searchTerm = intent.getStringExtra("landmarkName") ?: ""
        var dest: LatLng

        try {
            val geocodeResults = coder.getFromLocationName(searchTerm, 1)
            if (geocodeResults != null && geocodeResults.isNotEmpty()) {
                val firstResult = geocodeResults[0]
                val latitude = firstResult.latitude
                val longitude = firstResult.longitude

                dest = LatLng(latitude, longitude)

                // Remove previous marker, if any
                if (::marker.isInitialized) {
                    marker.remove()
                }

                // Get additional information about the location
                val locality = firstResult.locality ?: ""
                val featureName = firstResult.featureName ?: ""
                val country = firstResult.countryName ?: ""
                val road = firstResult.thoroughfare ?: ""

                // Construct a snippet that includes the additional information
                val snippet =
                    "Locality: $locality  Feature Name: $featureName Road: $road  Country: $country"

                // Add a marker to the map at the geocoded location
                marker = mMap.addMarker(
                    MarkerOptions().position(dest).title(searchTerm).snippet(snippet)
                )!!
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dest, 15f))
            } else {
                val sydney = LatLng(-34.0, 151.0)
                mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            }
        } catch (e: Exception) {
            Toast.makeText(
                applicationContext,
                "Failed to get location info $e",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
