package com.example.atm_machine_code;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText passwordEditText;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        name=findViewById(R.id.name);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString();
                String user_name = name.getText().toString();

                if (password.equals("1234") && user_name.equals("yogesh")) {

                    Intent intent = new Intent(MainActivity.this, activity_account.class);
                    startActivity(intent);
                }else if (password.equals("")){

                    Toast.makeText(MainActivity.this, "please enter the password", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(MainActivity.this, "Incorrect password or name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


