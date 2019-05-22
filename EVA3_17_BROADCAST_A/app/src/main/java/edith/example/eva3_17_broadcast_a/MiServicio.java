package edith.example.eva3_17_broadcast_a;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

public class MiServicio extends Service {
    Intent inMensaje;
    Thread tHilo;

    public MiServicio() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException( "Not yet implemented" );
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart( intent, startId );
        Log.wtf("MISERVICIO", "ONSTART");
        tHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try {
                        Thread.sleep( 1000 ); //Se tienen que utilizar hilos dentro del servicio
                        inMensaje = new Intent("MI_SERVICIO");
                        inMensaje.putExtra("MENSAJE", "onStart - thread");
                        sendBroadcast(inMensaje);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        tHilo.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("MISERVICIO", "ONDESTROY");
        tHilo.interrupt();
    }
}
