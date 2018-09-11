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
        lad = Double.parseDouble(txtLados.getText().toString());
        res = Metodos.areaCuadrado(lad);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.resultado);
        builder.setMessage(String.valueOf(res));
        builder.setNeutralButton("Ok",null);
        Dialog dialog = builder.create();
        dialog.show();
    }
}
