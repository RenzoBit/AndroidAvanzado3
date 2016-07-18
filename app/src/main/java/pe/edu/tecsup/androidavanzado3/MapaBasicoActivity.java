package pe.edu.tecsup.androidavanzado3;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaBasicoActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_basico);

        GoogleMap googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa_inicial)).getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
       /* if (id == R.id.action_settings) {
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }

}
