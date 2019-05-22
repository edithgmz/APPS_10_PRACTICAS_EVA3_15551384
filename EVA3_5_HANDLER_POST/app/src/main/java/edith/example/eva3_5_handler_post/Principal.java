package edith.example.eva3_5_handler_post;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwMensa;
    //HANDLER
    Handler hMiHandler = new Handler();
    //RUNNABLE que va a interactuar con la UI
    Runnable rRunInterfaz = new Runnable(){
        @Override
        public void run(){
            //Aquí se puede interactuar con la UI
            txtVwMensa.append("Hola Mundo\n");
        }
    };
    //HILO que hace el trabajo en 2do plano
    Thread tHiloPpal = new Thread(){
        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(1000);
                    hMiHandler.post(rRunInterfaz);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_principal );
        txtVwMensa = findViewById(R.id.txtVwMensa);
        tHiloPpal.start();
    }
}
