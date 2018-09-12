package aftr.tallertextview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class VolumenCono extends Activity {
    private EditText txtRad, txtAlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cono);

        txtRad = findViewById(R.id.txtRadio);
        txtAlt = findViewById(R.id.txtAltura);
    }

    public void resultado(View v){
        if (validar()) {
            double rad, alt, res;
            String op, dat, dec;
            rad = Double.parseDouble(txtRad.getText().toString());
            alt = Double.parseDouble(txtRad.getText().toString());
            res = Metodos.volumenCono(rad, alt);
            //Respuesta con dos cifras decimales
            dec = String.valueOf(String.format("%.2f", res));

            //Crear objeto y guardarlo en datos
            op = getResources().getString(R.string.volumenCono);
            dat = getResources().getString(R.string.radio) + String.valueOf(rad) + "\n"
                    + getResources().getString(R.string.altura) + String.valueOf(alt);
            Operacion o = new Operacion(op, dat, dec);
            o.guardar();

            //Mostrar resultado en dialogo
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.resultado);
            builder.setMessage(dec);
            builder.setNeutralButton("Ok", null);
            Dialog dialog = builder.create();
            dialog.show();
        }
    }

    public boolean validar(){
        if (txtRad.getText().toString().isEmpty()){
            txtRad.setError(getResources().getString(R.string.error_1));
            txtRad.requestFocus();
            return false;
        }
        if (txtRad.getText().toString().equals(".")){
            txtRad.setError(getResources().getString(R.string.error_2));
            txtRad.requestFocus();
            return false;
        }
        double valor = Double.parseDouble(txtRad.getText().toString());
        if (valor<=0){
            txtRad.setError(getResources().getString(R.string.error_2));
            txtRad.requestFocus();
            return false;
        }
        if (txtAlt.getText().toString().isEmpty()){
            txtAlt.setError(getResources().getString(R.string.error_1));
            txtAlt.requestFocus();
            return false;
        }
        if (txtAlt.getText().toString().equals(".")){
            txtAlt.setError(getResources().getString(R.string.error_2));
            txtAlt.requestFocus();
            return false;
        }
        double valor2 = Double.parseDouble(txtAlt.getText().toString());
        if (valor2<=0){
            txtAlt.setError(getResources().getString(R.string.error_2));
            txtAlt.requestFocus();
            return false;
        }
        return true;
    }

    public void borrar(View v){
        txtRad.setText("");
        txtAlt.setText("");
        txtRad.requestFocus();
    }
}
