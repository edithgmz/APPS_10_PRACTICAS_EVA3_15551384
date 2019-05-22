package edith.example.eva3_4_handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwMensa;
    final int HILO_CHAFA = 1000;
    final int HILO_CHAFA2 = 2000;
    Handler hMiHandler = new Handler(){
        //Pertenece al hilo principal
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int iVal = (int) msg.obj;
            txtVwMensa.append("HILO: " + msg.what + ", " + "Contador: " + iVal + "\n");
        }
    };
    Runnable rHilo = new Runnable() {
        @Override
        public void run() {
            int iCont = 0;
            while(true){
                Message msgMensa = hMiHandler.obtainMessage(HILO_CHAFA, iCont);
                hMiHandler.sendMessage(msgMensa);
                iCont++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    Runnable rHilo2 = new Runnable() {
        @Override
        public void run() {
            int iCont = 100;
            while(true){
                Message msgMensa = hMiHandler.obtainMessage(HILO_CHAFA2, iCont);
                hMiHandler.sendMessage(msgMensa);
                iCont++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwMensa = findViewById(R.id.txtVwMensa);
        Thread tHilo = new Thread(rHilo);
        tHilo.start();
        Thread tHilo2 = new Thread(rHilo2);
        tHilo2.start();
    }
}
