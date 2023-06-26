package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CalculatorActivity extends AppCompatActivity {

    //Deklarasi variable
    EditText angka_pertama, angka_kedua;
    Button tambah, kurang, kali, bagi, bersihkan, mod, pow, root, shift_l, shift_r;
    TextView hasil;

    // buat ngeformat hasil biar yg keluar desimalnya cuma satu
    static String format_hasil(double hasil) {
        return String.format("%.1f", hasil);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //getSupportActionBar().setTitle("");

        angka_pertama = (EditText) findViewById(R.id.angka_pertama);
        angka_kedua = (EditText) findViewById(R.id.angka_kedua);
        tambah = (Button)findViewById(R.id.tambah);
        kurang = (Button)findViewById(R.id.kurang);
        kali = (Button)findViewById(R.id.kali);
        bagi = (Button)findViewById(R.id.bagi);
        bersihkan = (Button) findViewById(R.id.bersihkan);
        mod = (Button) findViewById(R.id.mod);
        pow = (Button) findViewById(R.id.pow);
        root = (Button) findViewById(R.id.root);
        shift_l = (Button) findViewById(R.id.shift_l);
        shift_r = (Button) findViewById(R.id.shift_r);
        hasil = (TextView) findViewById(R.id.hasil);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((angka_pertama.getText().length()>0) && (angka_kedua.getText().length()>0))
                {
                    double angka1 = Double.parseDouble(angka_pertama.getText().toString());
                    double angka2 = Double.parseDouble(angka_kedua.getText().toString());
                    double result = angka1 + angka2;
                    hasil.setText(Double.toString(result));
                }
                else {
                    Toast toast = Toast.makeText(CalculatorActivity.this,
                            "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((angka_pertama.getText().length()>0) && (angka_kedua.getText().length()>0))
                {
                    double angka1 = Double.parseDouble(angka_pertama.getText().toString());
                    double angka2 = Double.parseDouble(angka_kedua.getText().toString());
                    double result = angka1 - angka2;
                    hasil.setText(Double.toString(result));
                }
                else {
                    Toast toast = Toast.makeText(CalculatorActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((angka_pertama.getText().length()>0) && (angka_kedua.getText().length()>0))
                {
                    double angka1 = Double.parseDouble(angka_pertama.getText().toString());
                    double angka2 = Double.parseDouble(angka_kedua.getText().toString());
                    double result = angka1 * angka2;
                    hasil.setText(Double.toString(result));
                }
                else {
                    Toast toast = Toast.makeText(CalculatorActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((angka_pertama.getText().length()>0) && (angka_kedua.getText().length()>0))
                {
                    double angka1 = Double.parseDouble(angka_pertama.getText().toString());
                    double angka2 = Double.parseDouble(angka_kedua.getText().toString());
                    double result = angka1 / angka2;
                    hasil.setText(format_hasil(result));
                }
                else {
                    Toast toast = Toast.makeText(CalculatorActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        // modulo
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((angka_pertama.getText().length()>0) && (angka_kedua.getText().length()>0)) {
                    double lhs = Double.parseDouble(angka_pertama.getText().toString());
                    double rhs = Double.parseDouble(angka_kedua.getText().toString());
                    hasil.setText(format_hasil(lhs % rhs));
                }
                else {
                    Toast toast = Toast.makeText(CalculatorActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        // pangkat
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((angka_pertama.getText().length()>0) && (angka_kedua.getText().length()>0)) {
                    double lhs = Double.parseDouble(angka_pertama.getText().toString());
                    double rhs = Double.parseDouble(angka_kedua.getText().toString());
                    hasil.setText(format_hasil(Math.pow(lhs, rhs)));
                }
                else {
                    Toast toast = Toast.makeText(CalculatorActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        // akar
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((angka_pertama.getText().length()>0) && (angka_kedua.getText().length()>0)) {
                    double lhs = Double.parseDouble(angka_pertama.getText().toString());
                    double rhs = Double.parseDouble(angka_kedua.getText().toString());
                    hasil.setText(format_hasil(Math.pow(lhs, -rhs)));
                }
                else {
                    Toast toast = Toast.makeText(CalculatorActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        // bitshift left
        shift_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((angka_pertama.getText().length()>0) && (angka_kedua.getText().length()>0)) {
                    int lhs = Integer.parseInt(angka_pertama.getText().toString());
                    int rhs = Integer.parseInt(angka_kedua.getText().toString());
                    hasil.setText(format_hasil((double)(lhs << rhs)));
                }
                else {
                    Toast toast = Toast.makeText(CalculatorActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        // bitshift right
        shift_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((angka_pertama.getText().length()>0) && (angka_kedua.getText().length()>0)) {
                    int lhs = Integer.parseInt(angka_pertama.getText().toString());
                    int rhs = Integer.parseInt(angka_kedua.getText().toString());
                    hasil.setText(format_hasil((double)(lhs >> rhs)));
                }
                else {
                    Toast toast = Toast.makeText(CalculatorActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        bersihkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angka_pertama.setText("");
                angka_kedua.setText("");
                hasil.setText("0");
                angka_pertama.requestFocus();
            }
        });
    }
}
