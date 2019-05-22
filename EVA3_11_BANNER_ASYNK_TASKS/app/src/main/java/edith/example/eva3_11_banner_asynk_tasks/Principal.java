package edith.example.eva3_11_banner_asynk_tasks;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    ImageView imgVwBanner;
    SeekBar skBrSpeed;
    TextView txtVwSeg;
    int iImagen = 0;
    int[] aiImagenes = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
    };
    int iVel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_principal );
        imgVwBanner = findViewById(R.id.imgVwBanner);
        skBrSpeed = findViewById(R.id.skBrSpeed);
        txtVwSeg = findViewById(R.id.txtVwSeg);
        MiClaseAsinc mObjClaseAsin = new MiClaseAsinc();
        mObjClaseAsin.execute( 1000 );
    }

    class MiClaseAsinc extends AsyncTask<Integer,String,Void> {
        //No se puede interactuar con la UI
        @Override
        protected Void doInBackground(Integer... integers) {
            while(true){
                try{
                    Thread.sleep( iVel * integers[0] );
                    publishProgress(  "s" );
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        //Se puede interactuar con la UI
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate( values );
            iVel = skBrSpeed.getProgress();
            iVel++;
            if(values.length > 0){
                txtVwSeg.setText(iVel + values[0]);
            }
            imgVwBanner.setImageResource(aiImagenes[iImagen]);
            if(iImagen == aiImagenes.length-1)
                iImagen = 0;
            else
                iImagen++;
        }
    }
}
