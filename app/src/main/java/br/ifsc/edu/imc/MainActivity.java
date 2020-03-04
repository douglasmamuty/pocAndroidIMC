package br.ifsc.edu.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextWeight;
    EditText editTextHeight;
    Button btnCalc;
    TextView txtViewIMC;
    ImageView image;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        btnCalc = findViewById(R.id.btnCalc);
        txtViewIMC = findViewById(R.id.txtViewIMC);
        image  = findViewById(R.id.image);
        seekBar = findViewById(R.id.seekBar);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double value = calcImc(Double.parseDouble(editTextWeight.getText().toString()),Double.parseDouble(editTextHeight.getText().toString()));

                txtViewIMC.setText(String.format("%.2f", value));

                seekBar.setProgress((int) value);

                if (value <= 18.5){
                    image.setImageResource(R.drawable.abaixopeso);
                }else if (value > 18.5 && value <= 24.9){
                    image.setImageResource(R.drawable.normal);
                } else if(value >= 25  && value <= 29.9){
                    image.setImageResource(R.drawable.normal);
                } else if (value > 30 && value <= 34.9){
                    image.setImageResource(R.drawable.obesidade1);
                } else if (value >= 35 && value <= 39.9){
                    image.setImageResource(R.drawable.obesidade2);
                } else if (value >= 40){
                    image.setImageResource(R.drawable.obesidade3);
                }

            }
        });
    }

    public double calcImc(Double weight, Double height){
        if ( height != 0 ) {
            return weight / (height * height);
        }

        return 0.0;
    }
}
