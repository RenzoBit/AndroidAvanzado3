package pe.edu.tecsup.androidavanzado3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapaTiposActivity extends AppCompatActivity {

    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_tipos);

        googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa_1)).getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(-12.04592, -77.030565));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);

        googleMap.moveCamera(center);
        googleMap.animateCamera(zoom);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tipos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.normal:
                tipoMapa = 0;
                cambiarTipoMapa();
                return true;
            case R.id.hybrid:
                tipoMapa = 1;
                cambiarTipoMapa();
                return true;
            case R.id.satellite:
                tipoMapa = 2;
                cambiarTipoMapa();
                return true;
            case R.id.terrain:
                tipoMapa = 3;
                cambiarTipoMapa();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    int tipoMapa = 0;

    private void cambiarTipoMapa() {
        switch (tipoMapa) {
            case 0:
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case 1:
                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case 2:
                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case 3:
                googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
        }
    }

}
