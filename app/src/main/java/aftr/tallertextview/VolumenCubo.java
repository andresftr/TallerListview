package aftr.tallertextview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class VolumenCubo extends Activity {
    private EditText txtLad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cubo);

        txtLad = findViewById(R.id.txtLado);
    }

    public void resultado(View v){
        double lad, res;
        String op, dat, dec;
        lad = Double.parseDouble(txtLad.getText().toString());
        res = Metodos.volumenCubo(lad);
        //Respuesta con dos cifras decimales
        dec = String.valueOf(String.format("%.2f",res));

        //Crear objeto y guardarlo en datos
        op = getResources().getString(R.string.volumenCubo);
        dat = getResources().getString(R.string.lado) + String.valueOf(lad);
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
        txtLad.setText("");
        txtLad.requestFocus();
    }
}
