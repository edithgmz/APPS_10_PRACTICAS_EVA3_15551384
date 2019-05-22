package edith.example.eva3_2_runnable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {
    Runnable rRun = new Runnable() {
        int i = 0;
        @Override
        public void run() {
            //for(int i = 0; i < 20; i++){
            while(true){
                try {
                    i++;
                    Log.wtf("Hilo", i + "");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Log.wtf("Estado", i + "DETENIDO");
                    e.printStackTrace();
                    break;
                }
            }
        }
    };
    Thread tHilo = new Thread(rRun);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        tHilo.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        tHilo.interrupt();
    }
}
