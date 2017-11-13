package com.example.a2dam.exament3ricardoborrull;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad3AD extends AppCompatActivity {
    private EditText edDia;
    private EditText edMes;
    private Button Guardar;
    private TextView edPago;
    public static final String PREFS = "My preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

        Guardar = (Button) findViewById(R.id.Guardar);
        edDia = (EditText) findViewById(R.id.edDia);
        edMes = (EditText) findViewById(R.id.edMes);
        edPago = (TextView) findViewById(R.id.edPago);

        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Dia = String.valueOf(edDia.getText());
                String Mes = String.valueOf(edMes.getText());

                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Actividad3AD.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();

                editor.putString("Dia", Dia);
                editor.putString("Mes", Mes);
                editor.commit();

                String dia;
                String mes;

                dia = mySharedPreferences.getString("Dia", "");
                mes = mySharedPreferences.getString("Mes", "");

                edPago.setText("Fue el día: "+dia+", del mes: "+mes+".");

                Toast.makeText(getApplicationContext(), "Cambios guardados", Toast.LENGTH_LONG).show();
            }
        });
    }
}
