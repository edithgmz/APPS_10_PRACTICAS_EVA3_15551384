package edith.example.eva3_3_sincronizacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwMensa;
    Thread tHilo = new Thread(){
        @Override
        public void run() {
            super.run();
            while (true){
                txtVwMensa.setText("MODIFICADO POR EL HILO");
                try {
                    Thread.sleep(1000);
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
        txtVwMensa.setText("AQUÍ NO FALLA");
        tHilo.start();
    }
}
