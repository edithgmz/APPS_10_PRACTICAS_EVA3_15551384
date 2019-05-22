package edith.example.eva3_13_servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MiServicio extends Service {
    public MiServicio() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException( "Not yet implemented" );
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("MISERVICIO", "ONCREATE");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart( intent, startId );
        Log.wtf("MISERVICIO", "ONSTART");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("MISERVICIO", "ONDESTROY");
    }
}
