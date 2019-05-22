package edith.example.eva3_10_asynk_tasks;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwMensa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_principal );
        txtVwMensa = findViewById( R.id.txtVwMensa );
        MiClaseAsinc mObjClaseAsin = new MiClaseAsinc();
        mObjClaseAsin.execute( 1000, 200, 500 );
    }

    class MiClaseAsinc extends AsyncTask<Integer,String,Void> {
        //Se puede interactuar con la UI
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtVwMensa.setText( "INICIANDO TAREA ASÍNCRONA\n\n" );
        }

        //No se puede interactuar con la UI
        //Equivalente del método run
        //Es el único completamente necesario
        @Override
        protected Void doInBackground(Integer... integers) {
            int i = 0;
            while(i < 15){
                try {
                    //Se debe asegurar de que los parámetros han sido enviados en execute porque puede generar excepciones
                    Thread.sleep( integers[0] );
                    publishProgress( i + ". Hola " + integers[1], "Otro " + integers[2], "Más cadenas\n" );
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        //Se puede interactuar con la UI
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate( values );
            if(values.length > 0){
                txtVwMensa.append( values[0] + ", " + values[1] + ", " + values[2]);
            }
        }

        //Se puede interactuar con la UI
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute( aVoid );
            txtVwMensa.append( "\nTERMINANDO TAREA ASÍNCRONA" );
        }
    }
}
