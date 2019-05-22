package edith.example.eva3_6_banner;

import android.os.Handler;
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
    //HANDLER
    Handler hnHandler = new Handler();
    //RUNNABLE que va a interactuar con la UI
    Runnable rnBanner = new Runnable(){
        @Override
        public void run(){
            //Aquí se puede interactuar con la UI
            iVel = skBrSpeed.getProgress();
            iVel++;
            txtVwSeg.setText(iVel + "s");
            imgVwBanner.setImageResource(aiImagenes[iImagen]);
            if(iImagen == aiImagenes.length-1)
                iImagen = 0;
            else
                iImagen++;
        }
    };
    //HILO que hace el trabajo en 2do plano
    Thread tHilo = new Thread(){
        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(iVel * 1000);
                    hnHandler.post(rnBanner);
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
        imgVwBanner = findViewById(R.id.imgVwBanner);
        skBrSpeed = findViewById(R.id.skBrSpeed);
        txtVwSeg = findViewById(R.id.txtVwSeg);
        tHilo.start();
    }
}
