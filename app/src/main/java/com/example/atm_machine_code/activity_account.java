package com.example.atm_machine_code;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activity_account extends AppCompatActivity {
    private TextView nameTextView, balanceTextView;
    private EditText withdrawEditText;

    private double balance = 10000.00;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        nameTextView = findViewById(R.id.nameTextView);
        balanceTextView = findViewById(R.id.balanceTextView);
        withdrawEditText = findViewById(R.id.withdrawEditText);


        balanceTextView.setText("Rs" + String.format("%.2f", balance));

        Button withdrawButton = findViewById(R.id.withdrawButton);
        Button finishButton = findViewById(R.id.finishButton);

        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double withdrawalAmount = Double.parseDouble(withdrawEditText.getText().toString());
                if (withdrawalAmount <= balance) {

                    balance -= withdrawalAmount;
                    balanceTextView.setText("Rs" + String.format("%.2f", balance));
                    Toast.makeText(activity_account.this, "Withdrawal successful", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(activity_account.this, "Insufficient balance", Toast.LENGTH_SHORT).show();
                }
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity_account.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}