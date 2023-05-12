package com.irsyadikhsanudin201011400947.pahlawanku;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    EditText txtName;
    Button btnMasuk;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        txtName = (EditText) findViewById(R.id.txtName);
        btnMasuk = (Button) findViewById(R.id.btnMasuk);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = txtName.getText().toString();
                    Bundle bundle = new Bundle();

                    if (name != "") {
                        AlertDialog.Builder alertLogin = new AlertDialog.Builder(FirstActivity.this);
                        alertLogin.setTitle("Selamat Datang").setMessage(name).setPositiveButton("OKE", (dialog, which) -> {
                            bundle.putString("NAMA", name);
                            Intent i = new Intent(FirstActivity.this, MainActivity.class);
                            i.putExtras(bundle);
                            startActivity(i);
                        });
                        AlertDialog alertDialog = alertLogin.create();
                        alertDialog.show();
                    } else {
                        Toast.makeText(FirstActivity.this, "Nama harus diisi !",Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(FirstActivity.this, "Error, Coba Lagi !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
