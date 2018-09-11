package com.example.opilane.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

ublic class MainActivity extends AppCompatActivity {
    private static  final double factor = 1.609344;

    EditText text;
    RadioButton ml, km;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.editText1);
        ml=findViewById(R.id.radioButton1);
        km=findViewById(R.id.radioButton2);
    }
    // KM-ist miilide konverter
    public static double toKm(double miles){
        return miles * factor;

    }
    // Miilidest KM konverter
    public static double toMl(double kilometers){
        return kilometers/ factor;
    }

    // Nupu tegevus väärtuste teisendamiseks
    public void onClick(View view){
        if (view.getId() == R.id.button1){
            text.setText("");
        }
        else if (view.getId() == R.id.button2){
            if (text.getText().length()==0){
                Toast.makeText(this, "Please enter a valid number!",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            double value=Double.parseDouble(text.getText().toString());
            if (ml.isChecked()) text.setText(String.valueOf(toKm(value)));
            else text.setText(String.valueOf(toMl(value)));
        }



    }
}
