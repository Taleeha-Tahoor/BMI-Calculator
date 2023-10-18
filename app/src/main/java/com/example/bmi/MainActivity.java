package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText wgt = findViewById(R.id.weight);
        EditText Ht_ft = findViewById(R.id.height);
        EditText Ht_In = findViewById(R.id.heightIn);
        Button calcu = findViewById(R.id.btn_Cal);
        TextView res = findViewById(R.id.result);
        LinearLayout lMain = findViewById(R.id.ll);

        calcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(wgt.getText().toString());
                int ft = Integer.parseInt(Ht_ft.getText().toString());
                int in = Integer.parseInt(Ht_In.getText().toString());

                int totalIn = ft*12 + in;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;
                double bmi = wt/(totalM*totalM);

                if(bmi > 25){
                    res.setText("You're Overweight!");
                    lMain.setBackgroundColor(getResources().getColor(R.color.Over));
                } else if (bmi < 18) {
                    res.setText("You're UnderWeight!");
                    lMain.setBackgroundColor(getResources().getColor(R.color.Under));
                }else {
                    res.setText("You're Healthy!");
                    lMain.setBackgroundColor(getResources().getColor(R.color.Healthy));
                }
            }
        });
    }
}