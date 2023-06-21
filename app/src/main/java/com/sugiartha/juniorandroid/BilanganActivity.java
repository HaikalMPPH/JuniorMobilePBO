package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BilanganActivity extends AppCompatActivity {

    private EditText angka;
    private TextView bilangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilangan);

        angka = findViewById(R.id.angka);
        bilangan = findViewById(R.id.bilangan);

        Button prosesButton = findViewById(R.id.proses);
        prosesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prosesAngka();
            }
        });
    }

    private void prosesAngka() {
        String input = angka.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Masukkan angka terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int nilai = Integer.parseInt(input);
            String hasil;
            if (nilai % 2 == 0) {
                hasil = "Bilangan Genap";
            } else {
                hasil = "Bilangan Ganjil";
            }
            String output = input + " Adalah " + hasil;
            bilangan.setText(output);
            bilangan.setVisibility(View.VISIBLE);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();

        }
    }
}