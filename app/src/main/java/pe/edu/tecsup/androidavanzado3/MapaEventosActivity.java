package pe.edu.tecsup.androidavanzado3;

import android.graphics.Point;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;

public class MapaEventosActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_eventos);

        final GoogleMap googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa_eventos)).getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(-12.04592, -77.030565));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);

        googleMap.moveCamera(center);
        googleMap.animateCamera(zoom);

        googleMap.setOnMapClickListener(new OnMapClickListener() {
            public void onMapClick(LatLng point) {
                Projection proj = googleMap.getProjection();
                Point coord = proj.toScreenLocation(point);

                Toast.makeText(MapaEventosActivity.this, "Click\n" + "Lat: " + point.latitude + "\n" + "Lng: "
                        + point.longitude + "\n" + "X: " + coord.x
                        + " - Y: " + coord.y, Toast.LENGTH_SHORT).show();
            }
        });

        googleMap.setOnCameraChangeListener(new OnCameraChangeListener() {
            public void onCameraChange(CameraPosition position) {
                Toast.makeText(
                        MapaEventosActivity.this,
                        "Cambio Cámara\n" + "Latitud: "
                                + position.target.latitude + "\n"
                                + "Longitud: " + position.target.longitude
                                + "\n" + "Zoom: " + position.zoom + "\n"
                                + "Orientación: " + position.bearing + "\n"
                                + "Ángulo: " + position.tilt,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
