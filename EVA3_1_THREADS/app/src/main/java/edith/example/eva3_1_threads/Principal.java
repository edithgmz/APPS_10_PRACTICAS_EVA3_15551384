package edith.example.eva3_1_threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {
    Thread miHilo = new Thread(){
        //Tareas en segundo plano
        @Override
        public void run() {
            super.run();
            for(int i = 0; i < 20; i++){
                try {
                    Log.wtf("Hilo", i + "");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        miHilo.start();
        //miHilo.run(); Se ejecuta dentro del hilo principal
        /*for(int i = 0; i < 20; i++){
            try {
                Log.wtf("Hilo", i + "");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
