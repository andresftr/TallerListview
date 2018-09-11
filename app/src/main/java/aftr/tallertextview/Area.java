package aftr.tallertextview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Area extends Activity {
    private ListView lv;
    private String [] opc;
    private Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        lv = findViewById(R.id.lstAreas);
        opc = getResources().getStringArray(R.array.opcAreas);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,opc);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        in = new Intent(Area.this,AreaCuadrado.class);
                        startActivity(in);
                        break;
                    case 1:
                        in = new Intent(Area.this,AreaRectangulo.class);
                        startActivity(in);
                        break;
                    case 2:
                        in = new Intent(Area.this,AreaCirculo.class);
                        startActivity(in);
                        break;
                }
            }
        });
    }
}
