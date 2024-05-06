package com.example.day10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tampilan extends AppCompatActivity {
    private TextView menuTextView;
    private TextView jumlahPorsiTextView;
    private TextView totalHargaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilanactivity);


        menuTextView = findViewById(R.id.menu);
        jumlahPorsiTextView = findViewById(R.id.jumlahporsi);
        totalHargaTextView = findViewById(R.id.totalharga);


        Intent intent = getIntent();
        String menu = intent.getStringExtra("Menu");
        int jumlahPorsi = intent.getIntExtra("JumlahPorsi", 0); // Ensure this is passed as an int
        double totalHarga = intent.getDoubleExtra("TotalHarga", 0.0);


        menuTextView.setText(menuTextView.getText() + menu);
        jumlahPorsiTextView.setText(jumlahPorsiTextView.getText() + Integer.toString(jumlahPorsi));
        totalHargaTextView.setText(totalHargaTextView.getText() + String.format("%.2f", totalHarga));
    }
}
