package aftr.tallertextview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AreaCirculo extends Activity {
    private EditText txtRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_circulo);

        txtRadio = findViewById(R.id.txtRadio);
    }

    public void resultado(View v){
        if (validar()){
            double rad, res;
            String op, dat, dec;
            rad = Double.parseDouble(txtRadio.getText().toString());
            res = Metodos.areaCirculo(rad);
            //Respuesta con dos cifras decimales
            dec = String.valueOf(String.format("%.2f",res));

            //Crear objeto y guardarlo en datos
            op = getResources().getString(R.string.areaCirculo);
            dat = getResources().getString(R.string.radio) + String.valueOf(rad);
            Operacion o = new Operacion(op,dat,dec);
            o.guardar();

            //Mostrar resultado en dialogo
            String mensaje = getResources().getString(R.string.area) + " " + dec;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.resultado);
            builder.setMessage(mensaje);
            builder.setNeutralButton("Ok",null);
            Dialog dialog = builder.create();
            dialog.show();
        }
    }

    public boolean validar(){
        if (txtRadio.getText().toString().isEmpty()){
            txtRadio.setError(getResources().getString(R.string.error_1));
            txtRadio.requestFocus();
            return false;
        }
        if (txtRadio.getText().toString().equals(".")){
            txtRadio.setError(getResources().getString(R.string.error_2));
            txtRadio.requestFocus();
            return false;
        }
        double valor = Double.parseDouble(txtRadio.getText().toString());
        if (valor<=0){
            txtRadio.setError(getResources().getString(R.string.error_2));
            txtRadio.requestFocus();
            return false;
        }
        return true;
    }

    public void borrar(View v){
        txtRadio.setText("");
        txtRadio.requestFocus();
    }
}
