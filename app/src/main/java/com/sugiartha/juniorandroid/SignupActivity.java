package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SignupActivity extends AppCompatActivity {

    Spinner spin;
    String spin_val;
    String[] gender = { "Laki-Laki", "Perempuan" };

    EditText fullNameEditText, usernameEditText, passwordEditText, addressEditText, emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        spin = findViewById(R.id.spinner_id);
        fullNameEditText = findViewById(R.id.full_name_edit_text);
        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        addressEditText = findViewById(R.id.address_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spin_val = gender[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<String> spin_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, gender);
        spin.setAdapter(spin_adapter);

        Button signUpButton = findViewById(R.id.sign_up_button);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDataValid()) {
                    showSuccessDialog();
                } else {
                    showIncompleteDataDialog();
                }
            }
        });
    }

    private boolean isDataValid() {
        String fullName = fullNameEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String address = addressEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();

        return !fullName.isEmpty() && !username.isEmpty() && !password.isEmpty()
                && !address.isEmpty() && !email.isEmpty();
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sukses");
        builder.setMessage("Akun Berhasil Dibuat");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void showIncompleteDataDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Peringatan");
        builder.setMessage("Masukkan data terlebih dahulu!");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}

