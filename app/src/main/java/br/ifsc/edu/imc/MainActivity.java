package br.ifsc.edu.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextWeight;
    EditText editTextHeight;
    Button btnCalc;
    TextView txtViewIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        btnCalc = findViewById(R.id.btnCalc);
        txtViewIMC = findViewById(R.id.txtViewIMC);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtViewIMC.setText(String.format("%.2f", calcImc(Double.parseDouble(editTextWeight.getText().toString()),Double.parseDouble(editTextHeight.getText().toString()))));
            }
        });
    }

    public Double calcImc(Double weight, Double height){
        if ( height != 0 ) {
            return weight / (height * height);
        }

        return 0.0;
    }
}
