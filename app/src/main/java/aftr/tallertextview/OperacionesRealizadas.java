package aftr.tallertextview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class OperacionesRealizadas extends Activity {
    private TableLayout tabla;
    private ArrayList<Operacion> operaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones_realizadas);
        tabla = findViewById(R.id.tabla);
        operaciones = Datos.obtener();

        for (int i = 0; i < operaciones.size(); i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);

            int pos = i+1;
            c1.setText("" + pos);
            c2.setText(operaciones.get(i).getOper());
            c3.setText(operaciones.get(i).getDat());
            c4.setText(operaciones.get(i).getRes());

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);

            tabla.addView(fila);
        }
    }
}
