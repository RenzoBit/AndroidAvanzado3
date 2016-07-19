package pe.edu.tecsup.androidavanzado3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaBasicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_basico);

        GoogleMap googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa_inicial)).getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        // googleMap.setTrafficEnabled(true);

        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(-12.04592, -77.030565));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(10);//18

        googleMap.moveCamera(center);
        googleMap.animateCamera(zoom);

        final LatLng centroLima = new LatLng(-12.04592, -77.030565);
        Marker mCentroLima = googleMap.addMarker(new MarkerOptions().position(centroLima).title("Centro de Lima"));
        mCentroLima.setDraggable(true);

        final LatLng santaAnita = new LatLng(-12.026718, -76.9725697);
        Marker msantaAnita = googleMap.addMarker(new MarkerOptions().position(santaAnita).title("Santa Anita"));
        msantaAnita.setDraggable(true);
    }

}
