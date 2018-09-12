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
        if (validar()) {
            double lad, res;
            String op, dat, dec;
            lad = Double.parseDouble(txtLad.getText().toString());
            res = Metodos.volumenCubo(lad);
            //Respuesta con dos cifras decimales
            dec = String.valueOf(String.format("%.2f", res));

            //Crear objeto y guardarlo en datos
            op = getResources().getString(R.string.volumenCubo);
            dat = getResources().getString(R.string.lado) + String.valueOf(lad);
            Operacion o = new Operacion(op, dat, dec);
            o.guardar();

            //Mostrar resultado en dialogo
            String mensaje = getResources().getString(R.string.volumen) + " " + dec;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.resultado);
            builder.setMessage(mensaje);
            builder.setNeutralButton("Ok", null);
            Dialog dialog = builder.create();
            dialog.show();
        }
    }

    public boolean validar(){
        if (txtLad.getText().toString().isEmpty()){
            txtLad.setError(getResources().getString(R.string.error_1));
            txtLad.requestFocus();
            return false;
        }
        if (txtLad.getText().toString().equals(".")){
            txtLad.setError(getResources().getString(R.string.error_2));
            txtLad.requestFocus();
            return false;
        }
        double valor = Double.parseDouble(txtLad.getText().toString());
        if (valor<=0){
            txtLad.setError(getResources().getString(R.string.error_2));
            txtLad.requestFocus();
            return false;
        }
        return true;
    }

    public void borrar(View v){
        txtLad.setText("");
        txtLad.requestFocus();
    }
}
