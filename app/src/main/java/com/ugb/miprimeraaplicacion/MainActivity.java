package com.ugb.miprimeraaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ugb.miprimeraplicacion.R;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tempVal;
    RadioGroup rgb;
    RadioButton opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tempVal = findViewById(R.id.txtNum2);
        double num2 = Double.parseDouble(tempVal.getText().toString());
        tempVal = findViewById(R.id.txtNum1);
        double num1 = Double.parseDouble(tempVal.getText().toString());
        double respuesta = num1 + num2;

        opt = findViewById(R.id.optSuma);
        if (opt.isChecked()) {
            respuesta = num1 + num2;
        }
        opt = findViewById(R.id.optResta);
        if (opt.isChecked()) {
            respuesta = num1 - num2;
        }
        opt = findViewById(R.id.optMultiplicacion);
        if (opt.isChecked()) {
            respuesta = num1 * num2;
        }
        opt = findViewById(R.id.optDivision);
        if (opt.isChecked()) {
            respuesta = num1 / num2;
        }
        tempVal = findViewById(R.id.lblRespuesta);
        tempVal.setText("Respuesta: " + respuesta);
    }
}
