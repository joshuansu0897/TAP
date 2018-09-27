package com.example.joshuansu.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        final TextView a = findViewById(R.id.a);
        final TextView b = findViewById(R.id.b);
        final TextView c = findViewById(R.id.c);

        final TextView x1 = findViewById(R.id.x1);
        final TextView x2 = findViewById(R.id.x2);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int aValue = 0;
                int bValue = 0;
                int cValue = 0;
                try {
                    aValue = Integer.parseInt(a.getText().toString());
                    bValue = Integer.parseInt(b.getText().toString());
                    cValue = Integer.parseInt(c.getText().toString());
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Numeros enteros, profavor....",
                            Toast.LENGTH_LONG).show();
                }

                double x1Res = -bValue+Math.sqrt(bValue*bValue-4*aValue*cValue)/(2*aValue);
                double x2Res =-bValue-Math.sqrt(bValue*bValue-4*aValue*cValue)/(2*aValue);

                DecimalFormat df = new DecimalFormat("#.##");

                x1.setText(String.valueOf(df.format(x1Res)));
                x2.setText(String.valueOf(df.format(x2Res)));

            }
        });

    }
}
