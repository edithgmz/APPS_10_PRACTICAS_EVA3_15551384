package edith.example.eva3_17_broadcast_a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwDatos;
    Intent inMiServicio;
    BroadcastReceiver brReceptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_principal );
        txtVwDatos = findViewById( R.id.txtVwDatos );
        inMiServicio = new Intent(this, MiServicio.class);
        //Crear el broadcast
        brReceptor = new MiBroadCast();
        //Decirle el servicio a escuchar
        IntentFilter ifMiServicio = new IntentFilter("MI_SERVICIO");
        registerReceiver(brReceptor, ifMiServicio);
    }

    //Iniciar servicio
    public void onClickIni(View v){
        startService(inMiServicio);
    }
    //Detener servicio
    public void onClicFin(View v){
        stopService(inMiServicio);
    }

    class MiBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Interpretar datos, ponerlos en el TextView
            String sCade = intent.getStringExtra("MENSAJE");
            txtVwDatos.append(sCade + "\n");
        }

    }
}
