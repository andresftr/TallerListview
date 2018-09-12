package aftr.tallertextview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class VolumenCilindro extends Activity {
    private EditText txtRad, txtAlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cilindro);

        txtRad = findViewById(R.id.txtRadio);
        txtAlt = findViewById(R.id.txtAltura);
    }

    public void resultado(View v){
        double rad, alt, res;
        String op, dat, dec;
        rad = Double.parseDouble(txtRad.getText().toString());
        alt = Double.parseDouble(txtRad.getText().toString());
        res = Metodos.volumenCilindro(rad,alt);
        //Respuesta con dos cifras decimales
        dec = String.valueOf(String.format("%.2f",res));

        //Crear objeto y guardarlo en datos
        op = getResources().getString(R.string.volumenCilindro);
        dat = getResources().getString(R.string.radio) + String.valueOf(rad)+ "\n"
                + getResources().getString(R.string.altura) + String.valueOf(alt);
        Operacion o = new Operacion(op,dat,dec);
        o.guardar();

        //Mostrar resultado en dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.resultado);
        builder.setMessage(dec);
        builder.setNeutralButton("Ok",null);
        Dialog dialog = builder.create();
        dialog.show();
    }

    public void borrar(View v){
        txtRad.setText("");
        txtAlt.setText("");
        txtRad.requestFocus();
    }
}
