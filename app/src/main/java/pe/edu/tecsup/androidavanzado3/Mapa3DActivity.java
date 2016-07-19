package pe.edu.tecsup.androidavanzado3;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class Mapa3DActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa3_d);

        GoogleMap googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa_3d)).getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng centroLima = new LatLng(-12.04592, -77.030565);
        CameraPosition camPos = new CameraPosition.Builder().target(centroLima)
                .zoom(18).bearing(45) // Grados de orientación
                .tilt(70) // Grados de ángulo de proyección
                .build();

        CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);

        googleMap.animateCamera(camUpd3);
    }

}
