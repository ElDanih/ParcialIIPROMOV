package edu.uniciencia.programacionmovil.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {
    private TextView lblResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        lblResult = findViewById(R.id.lblResult);
        mostarResumen();


    }

    private void mostarResumen() {
        SharedPreferences preferences = getSharedPreferences("productos", Context.MODE_PRIVATE);
        String resultText = "";
        int valor = 15000;
        String cantidad1 = preferences.getString("cantidad1", "0");
        String cantidad2 = preferences.getString("cantidad2", "0");
        String cantidad3 = preferences.getString("cantidad3", "0");

        resultText += "Producto P1 \n " +  "Cantidad P1: " + cantidad1 + "\n" + "Valor P1: " + Integer.parseInt(cantidad1) * valor + "\n \n \n" +
                "Producto P2 \n " +  "Cantidad P2: " + cantidad2 + "\n" + "Valor P2: " + Integer.parseInt(cantidad2) * valor + "\n \n \n" +
                "Producto P3 \n " +  "Cantidad P3: " + cantidad3 + "\n" + "Valor P3: " + Integer.parseInt(cantidad3) * valor + "\n \n \n";

        lblResult.setText(resultText);
    }

    public void btnRegresar(View view) {
        finish();
    }
}