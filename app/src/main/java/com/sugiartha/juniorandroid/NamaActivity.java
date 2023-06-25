package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NamaActivity extends AppCompatActivity {

    Button btnOk;
    EditText editNama;
    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nama);

        btnOk = findViewById(R.id.btnOk);
        editNama = findViewById(R.id.editNama);
        txtHasil = findViewById(R.id.txtHasil);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editNama.getText().toString();
                if (!nama.isEmpty()) {
                    String message = "Selamat Datang " + nama + "! Peserta VSGA";
                    txtHasil.setText(message);
                    Toast.makeText(NamaActivity.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NamaActivity.this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

