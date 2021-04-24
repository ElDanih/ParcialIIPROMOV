package edu.uniciencia.programacionmovil.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtProducto1, txtProducto2, txtProducto3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtProducto1 = findViewById(R.id.txtProducto1);
        txtProducto2 = findViewById(R.id.txtProducto2);
        txtProducto3 = findViewById(R.id.txtProducto3);
    }

    public void btnGuardar(View view){
        if(txtProducto1.getText().toString().length() == 0
                && txtProducto2.getText().toString().length() == 0
                && txtProducto3.getText().toString().length() == 0 ){
            Toast.makeText(this,"No se admiten campos vacíos", Toast.LENGTH_SHORT).show();
        } else {

            SharedPreferences preferences = getSharedPreferences("productos", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            if(txtProducto1.getText().toString().length() > 0 ){
                String cantidad1 = preferences.getString("cantidad1", "0");
                int cant1Total = Integer.parseInt(cantidad1) + Integer.parseInt(txtProducto1.getText().toString());
                editor.putString("cantidad1", String.valueOf(cant1Total));
            }
            if(txtProducto2.getText().toString().length() > 0 ){
                String cantidad2 = preferences.getString("cantidad2", "0");
                int cant2Total = Integer.parseInt(cantidad2) + Integer.parseInt(txtProducto2.getText().toString());
                editor.putString("cantidad2", String.valueOf(cant2Total));
            }
            if(txtProducto3.getText().toString().length() > 0 ){
                String cantidad3 = preferences.getString("cantidad3", "0");
                int cant3Total = Integer.parseInt(cantidad3) + Integer.parseInt(txtProducto3.getText().toString());
                editor.putString("cantidad3", String.valueOf(cant3Total));
            }
            editor.commit();
        }

    }

    public void btnMostrarResumen(View view){
        Intent intent = new Intent(this, Resumen.class);
        startActivity(intent);


    }
}