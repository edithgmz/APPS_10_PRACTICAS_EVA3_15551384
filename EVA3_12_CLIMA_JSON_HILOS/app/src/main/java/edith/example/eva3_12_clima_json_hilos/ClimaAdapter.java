package edith.example.eva3_12_clima_json_hilos;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ClimaAdapter  extends ArrayAdapter<Clima> {
    private Context cApp;
    private int iMiLayout;
    private List<Clima> acDatos;

    public ClimaAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        cApp = context;
        iMiLayout = resource;
        acDatos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        ImageView imgVwClima;
        TextView txtVwCd, txtVwTemp, txtVwClima, txtVwDesc;

        View vwMiLayout = convertView;

        if(vwMiLayout == null){ //No existe la fila, hay que crearla
            LayoutInflater liCrearLayout = ((Activity)cApp).getLayoutInflater();
            vwMiLayout = liCrearLayout.inflate(iMiLayout, parent, false);
        }

        imgVwClima = vwMiLayout.findViewById(R.id.imgVwClima);
        txtVwCd = vwMiLayout.findViewById(R.id.txtVwCd);
        txtVwTemp = vwMiLayout.findViewById(R.id.txtVwTemp);
        txtVwClima = vwMiLayout.findViewById(R.id.txtVwClima);
        txtVwDesc = vwMiLayout.findViewById(R.id.txtVwDesc);

        Clima cClimaCd = acDatos.get(position);

        imgVwClima.setImageResource(cClimaCd.getImagen_clima());
        txtVwCd.setText(cClimaCd.getCiudad());
        txtVwTemp.setText(cClimaCd.getTemp() + " °F");
        txtVwClima.setText(cClimaCd.getClima());
        txtVwDesc.setText(cClimaCd.getDesc_clima());

        return vwMiLayout;
    }
}
