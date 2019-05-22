package edith.example.eva3_13_servicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {
    Intent inMiServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_principal );
        inMiServicio = new Intent(this, MiServicio.class);
    }

    //Iniciar servicio
    public void onClickIni(View v){
        startService(inMiServicio);
    }

    //Detener servicio
    public void onClicFin(View v){
        stopService(inMiServicio);
    }
}
