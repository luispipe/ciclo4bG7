package com.example.unleeg7.View.ui.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.unleeg7.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.osmdroid.config.Configuration
import org.osmdroid.library.BuildConfig
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class ShippingFragment : Fragment(), OnMapReadyCallback {

    lateinit var googleMap: GoogleMap

    companion object{
        const val REQUEST_CODE_LOCATION=0
    }

    lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_shipping, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment= this.childFragmentManager.findFragmentById(R.id.mapGoogle) as SupportMapFragment
        mapFragment.getMapAsync(this)


        //Conexión Open Street Map y la APP
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID)

        //Open Street Map
        mapView= view.findViewById(R.id.mapOpenStreet)
        mapView.setTileSource(TileSourceFactory.MAPNIK)

        //Localización

        val geoPoint= GeoPoint(5.070275,-75.513817)
        val mapController= mapView.controller
        mapController.setZoom(16.0)
        mapController.setCenter(geoPoint)

        //Marcador
        val marker= Marker(mapView)
        marker.setPosition(geoPoint)
        marker.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM)
        marker.setTitle("UNLeeG7")
        mapView.overlays.add(marker)
    }

    override fun onMapReady(map: GoogleMap) {
        val colombia= LatLng(5.070275,-75.513817)
        map?.let {
            this.googleMap= it
            map.addMarker(
                MarkerOptions()
                .position(colombia)
                .title("Marcador Manizales")
            )
        }
        enableLocation()
    }

    @SuppressLint("MissingPermission")
    fun enableLocation(){
        if(!::googleMap.isInitialized)return
            if (IsLocationPermissionGrated()){
                googleMap.isMyLocationEnabled=true
            }else{
                requestLocationPermission()
            }
    }

    fun IsLocationPermissionGrated()=ContextCompat.checkSelfPermission(
        this.requireContext(),
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )==PackageManager.PERMISSION_GRANTED

    fun requestLocationPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this.requireActivity(),android.Manifest.permission.ACCESS_FINE_LOCATION)){
            Toast.makeText(this.context,"Activar permisos de ubicación",Toast.LENGTH_LONG).show()
        }else{
            ActivityCompat.requestPermissions(this.requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                com.example.unleeg7.View.ui.fragments.ShippingFragment.Companion.REQUEST_CODE_LOCATION
                )
        }
    }



}