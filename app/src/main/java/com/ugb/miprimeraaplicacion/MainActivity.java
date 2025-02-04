package com.ugb.miprimeraaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.ugb.miprimeraplicacion.R;

public class MainActivity extends AppCompatActivity {

    private EditText txtNum1, txtNum2;
    private TextView lblRespuesta;
    private RadioButton optSuma, optResta, optMultiplicacion, optDivision, optExponente, optPorcentaje, optRaiz, optFactorial;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        lblRespuesta = findViewById(R.id.lblRespuesta);
        optSuma = findViewById(R.id.optSuma);
        optResta = findViewById(R.id.optResta);
        optMultiplicacion = findViewById(R.id.optMultiplicacion);
        optDivision = findViewById(R.id.optDivision);
        optExponente = findViewById(R.id.optExponente);
        optPorcentaje = findViewById(R.id.optPorcentaje);
        optRaiz = findViewById(R.id.optRaiz);
        optFactorial = findViewById(R.id.optFactorial);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    private void calcular() {
        double num1 = Double.parseDouble(txtNum1.getText().toString());
        double num2 = Double.parseDouble(txtNum2.getText().toString());
        double resultado = 0;

        if (optSuma.isChecked()) {
            resultado = num1 + num2;
        } else if (optResta.isChecked()) {
            resultado = num1 - num2;
        } else if (optMultiplicacion.isChecked()) {
            resultado = num1 * num2;
        } else if (optDivision.isChecked()) {
            if (num2 != 0) {
                resultado = num1 / num2;
            } else {
                lblRespuesta.setText("Error: División por cero");
                return;
            }
        } else if (optExponente.isChecked()) {
            resultado = Math.pow(num1, num2);
        } else if (optPorcentaje.isChecked()) {
            resultado = (num1 * num2) / 100;
        } else if (optRaiz.isChecked()) {
            if (num1 >= 0) {
                resultado = Math.sqrt(num1);
            } else {
                lblRespuesta.setText("Error: Raíz de número negativo");
                return;
            }
        } else if (optFactorial.isChecked()) {
            if (num1 >= 0 && num1 == (int) num1) {
                resultado = factorial((int) num1);
            } else {
                lblRespuesta.setText("Error: Factorial de número no entero o negativo");
                return;
            }
        }

        lblRespuesta.setText("Respuesta: " + resultado);
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}