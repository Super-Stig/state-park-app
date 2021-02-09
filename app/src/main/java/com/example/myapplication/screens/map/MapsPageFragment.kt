package com.example.myapplication.screens.map

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.R

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*
import android.Manifest
import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databaces.map_markers_database.MapMarkersDatabase
import com.google.android.gms.maps.CameraUpdateFactory

class MapsPageFragment : Fragment(), ActivityCompat.OnRequestPermissionsResultCallback {

    private val REQUEST_LOCATION_PERMISSION = 1
    private lateinit var map: GoogleMap
    //
    //
    //
    lateinit var viewModel: MapPageViewModel
    lateinit var listOfMarkers: MutableList<MapMarkersData>


    private val callback = OnMapReadyCallback { googleMap ->



        val latitude = 38.0131
        val longitude = -121.1013
        val zoomLevel = 13F

        val homeLatLng = LatLng(latitude,longitude)

        listOfMarkers = mutableListOf(MapMarkersData("home",latitude,longitude))

        map = googleMap
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng,zoomLevel))
        enableMyLocation()
        setMapLongClick(googleMap)
        setPoiClick(googleMap)
    }

    private fun loadSavedLocations() {

        if (listOfMarkers.isNotEmpty()     ){
        for (data in listOfMarkers){
            val snippet = String.format(
                Locale.getDefault(),
                "Lat: %1$.5f, Long: %2$.5f",
                data.latitude,
                data.longitude
            )
            val location:LatLng = LatLng(data.latitude, data.longitude)

            map.addMarker(
                MarkerOptions().position(location)
                    .title(data.name)
                    .snippet(snippet)
            )

        }}

    }

    private fun setMapLongClick(map:GoogleMap){

        map.setOnMapLongClickListener { latLng ->
            viewModel.addMarker(MapMarkersData("Dropped Pin",latLng.latitude, latLng.longitude))
            val snippet = String.format(
                Locale.getDefault(),
                "Lat: %1$.5f, Long: %2$.5f",
                latLng.latitude,
                latLng.longitude
            )
            map.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title("Dropped Pin")
                    .snippet(snippet)
            )
        }
    }


    private fun setPoiClick(map: GoogleMap){
        map.setOnPoiClickListener { poi ->
            val poiMarker = map.addMarker(
                MarkerOptions()
                    .position(poi.latLng)
                    .title(poi.name)
            )
            poiMarker.showInfoWindow()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application: Application = requireNotNull(this.activity).application

        val dataSource = MapMarkersDatabase.getInstance(application).mapMarkersDatabaseDao
        val viewModelFactory = MapsPageModelFactory(dataSource,application)
        var viewModelProvider = ViewModelProvider(this,viewModelFactory).get(MapPageViewModel::class.java)

        viewModel = viewModelProvider

        viewModel.listOfAllMarkers().observe(viewLifecycleOwner, androidx.lifecycle.Observer{
            it?.let {
                listOfMarkers = it
                loadSavedLocations()
            }
        })




        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun enableMyLocation(){
        if (ContextCompat.checkSelfPermission(requireContext().applicationContext,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            map.isMyLocationEnabled = true
        } else{
            ActivityCompat.requestPermissions(this.requireActivity(),
            arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == REQUEST_LOCATION_PERMISSION){
            if(grantResults.isNotEmpty() && (grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                enableMyLocation()
            }
        }
    }



}