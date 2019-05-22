package edith.example.eva3_8_ejemplo_hilos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class Principal extends AppCompatActivity {
    ImageView imgVwMostrar;
    Bitmap bImagen;
    Handler hHandler = new Handler();
    Runnable rRunUI = new Runnable() {
        @Override
        public void run() {
            //Mostrar imagen
            imgVwMostrar.setImageBitmap(bImagen);
        }
    };
    Thread tHilo = new Thread() {
        @Override
        public void run() {
            //Cargar imagen
            bImagen = cargarImagen("https://pm1.narvii.com/6770/852a0fb13dbd4c2adca8c503ce61b9033a1754c6v2_hq.jpg");
            hHandler.post(rRunUI);
            //Otra forma de hacerlo
            /*imgVwMostrar.post(new Runnable(){
                @Override
                public void run(){
                    //Mostrar imagen
                    imgVwMostrar.setImageBitmap(bImagen);
                }
            });*/
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_principal );
        imgVwMostrar = findViewById(R.id.imgVwMostrar);
        //Bitmap bImagen = cargarImagen("https://pm1.narvii.com/6770/852a0fb13dbd4c2adca8c503ce61b9033a1754c6v2_hq.jpg");
        //imgVwMostrar.setImageBitmap(bImagen);
        tHilo.start();
    }

    private Bitmap cargarImagen(String url) {
        try {
            InputStream isImagen = (InputStream) new URL(url).getContent();
            Bitmap bBitMap = BitmapFactory.decodeStream(isImagen);
            return bBitMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
