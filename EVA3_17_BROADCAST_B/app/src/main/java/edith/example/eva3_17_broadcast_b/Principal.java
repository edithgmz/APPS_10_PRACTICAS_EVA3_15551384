package edith.example.eva3_17_broadcast_b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwDatos;
    BroadcastReceiver brReceptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_principal );
        txtVwDatos = findViewById( R.id.txtVwMensaje );
        //Crear el broadcast
        brReceptor = new MiBroadCast();
        //Decirle el servicio a escuchar
        IntentFilter ifMiServicio = new IntentFilter("MI_SERVICIO");
        registerReceiver(brReceptor, ifMiServicio);
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
