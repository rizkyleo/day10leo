package com.example.day10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton nasigorengRadioButton;
    private RadioButton miegorengRadioButton;
    private RadioButton mierebusRadioButton;
    private RadioButton nasiudukRadioButton;
    private RadioButton tehesRadioButton;
    private RadioButton esjerukRadioButton;
    private EditText jumlahporsiEditText;
    private Button pesanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing components
        nasigorengRadioButton = findViewById(R.id.tv_nasigoreng);
        miegorengRadioButton = findViewById(R.id.tv_miegoreng);
        mierebusRadioButton = findViewById(R.id.tv_mierebus);
        nasiudukRadioButton = findViewById(R.id.tv_nasiuduk);
        tehesRadioButton = findViewById(R.id.tv_tehes);
        esjerukRadioButton = findViewById(R.id.tv_esjeruk);
        jumlahporsiEditText = findViewById(R.id.tv_jumlahporsi);
        pesanButton = findViewById(R.id.pesan_button);

        pesanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int jumlah = Integer.parseInt(jumlahporsiEditText.getText().toString());
                    calculateTotal(jumlah);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Please enter a valid number of portions", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void calculateTotal(int jumlah) {
        int pricePerItem = 0;

        if (nasigorengRadioButton.isChecked()) pricePerItem = 10000;
        else if (miegorengRadioButton.isChecked()) pricePerItem = 8000;
        else if (mierebusRadioButton.isChecked()) pricePerItem = 8000;
        else if (nasiudukRadioButton.isChecked()) pricePerItem = 11000;

        if (tehesRadioButton.isChecked()) pricePerItem += 5000;
        else if (esjerukRadioButton.isChecked()) pricePerItem += 7000;

        int total = jumlah * pricePerItem;
        showTotalPrice(total);
    }

    private void showTotalPrice(int total) {
        Toast.makeText(MainActivity.this, "Total Price: Rp " + total, Toast.LENGTH_LONG).show();
    }
}
