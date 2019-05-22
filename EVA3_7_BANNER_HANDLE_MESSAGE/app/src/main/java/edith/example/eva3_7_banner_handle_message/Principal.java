package edith.example.eva3_7_banner_handle_message;

import android.os.Handler;
import android.os.Message;
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
    final int HILO = 1111;
    int[] aiImagenes = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
    };
    int iVel;
    //HANDLER
    Handler hnHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int iImg = msg.arg1;
            int iVel = msg.arg2;
            imgVwBanner.setImageResource(aiImagenes[iImg]);
            txtVwSeg.setText(iVel + "s");
        }
    };
    //RUNNABLE que va a interactuar con la UI
    Runnable rnBanner = new Runnable(){
        @Override
        public void run(){
            //Aquí se puede interactuar con la UI
            while(true){
                if(iImagen == aiImagenes.length-1)
                    iImagen = 0;
                else
                    iImagen++;
                iVel = skBrSpeed.getProgress();
                iVel++;
                Message msgMensa = hnHandler.obtainMessage(HILO, iImagen, iVel);
                hnHandler.sendMessage(msgMensa);
                try{
                    Thread.sleep(iVel * 1000);
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
        Thread tHilo = new Thread(rnBanner);
        tHilo.start();
    }
}
