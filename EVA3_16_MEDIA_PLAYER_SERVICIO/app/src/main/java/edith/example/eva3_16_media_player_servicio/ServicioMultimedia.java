package edith.example.eva3_16_media_player_servicio;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class ServicioMultimedia extends Service {
    MediaPlayer mpMultimedia = null;

    public ServicioMultimedia() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException( "Not yet implemented" );
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mpMultimedia = MediaPlayer.create( getApplicationContext(), R.raw.granrodeo_rain_beat );
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart( intent, startId );
        if(mpMultimedia != null){
            mpMultimedia.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mpMultimedia != null){
            mpMultimedia.stop();
            mpMultimedia.release();
        }
    }
}
