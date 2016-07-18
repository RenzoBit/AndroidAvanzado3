package pe.edu.tecsup.androidavanzado3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMapaBasico, btnTiposMapa, btnMapa3D, btnEventosMapas, btnGCM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMapaBasico = (Button) findViewById(R.id.btnMapaBasico);
        btnTiposMapa = (Button) findViewById(R.id.btnTiposMapa);
        btnMapa3D = (Button) findViewById(R.id.btnMapa3D);
        btnEventosMapas = (Button) findViewById(R.id.btnEventosMapas);
        btnGCM = (Button) findViewById(R.id.btnGCM);

        btnMapaBasico.setOnClickListener(this);
        btnTiposMapa.setOnClickListener(this);
        btnMapa3D.setOnClickListener(this);
        btnEventosMapas.setOnClickListener(this);
        btnGCM.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnMapaBasico:
                intent = new Intent(MainActivity.this, MapaBasicoActivity.class);
                break;
            case R.id.btnTiposMapa:
                intent = new Intent(MainActivity.this, MapaTiposActivity.class);
                break;
            case R.id.btnMapa3D:
                intent = new Intent(MainActivity.this, Mapa3DActivity.class);
                break;
            case R.id.btnEventosMapas:
                intent = new Intent(MainActivity.this, MapaEventosActivity.class);
                break;
            case R.id.btnGCM:
                intent = new Intent(MainActivity.this, GCMTestActivity.class);
                break;
        }
        startActivity(intent);
    }
}
