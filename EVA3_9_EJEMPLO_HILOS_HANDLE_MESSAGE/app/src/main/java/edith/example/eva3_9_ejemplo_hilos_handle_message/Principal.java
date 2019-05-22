package edith.example.eva3_9_ejemplo_hilos_handle_message;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class Principal extends AppCompatActivity {
    ImageView imgVwMostrar;
    Bitmap bImagen;
    final int HILO = 2222;
    Handler hHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bitmap bVal = (Bitmap) msg.obj;
            //Mostrar imagen
            imgVwMostrar.setImageBitmap(bVal);
        }
    };
    Runnable rRunUI = new Runnable() {
        @Override
        public void run() {
            //Cargar imagen
            bImagen = cargarImagen("https://pre00.deviantart.net/fb5d/th/pre/i/2018/075/5/3/chibi_s_odachuu_by_kodoku18-dc61z4f.jpg");
            Message msgMensa = hHandler.obtainMessage(HILO, bImagen);
            hHandler.sendMessage(msgMensa);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_principal );
        imgVwMostrar = findViewById(R.id.imgVwMostrar);
        Thread tHilo = new Thread(rRunUI);
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
