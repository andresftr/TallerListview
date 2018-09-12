package aftr.tallertextview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AreaCuadrado extends Activity {
    private EditText txtLados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_cuadrado);
        txtLados = findViewById(R.id.txtLados);
    }

    public void resultado(View v){
        double lad, res;
        String op, dat, dec;
        lad = Double.parseDouble(txtLados.getText().toString());
        res = Metodos.areaCuadrado(lad);
        //Respuesta con dos cifras decimales
        dec = String.valueOf(String.format("%.2f",res));

        //Crear objeto y guardarlo en datos
        op = getResources().getString(R.string.areaCuadrado);
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
        txtLados.setText("");
        txtLados.requestFocus();
    }
}
