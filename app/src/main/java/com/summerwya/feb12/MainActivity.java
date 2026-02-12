package com.summerwya.feb12;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText repeatedPassword = findViewById(R.id.repeatedPassword);

        findViewById(R.id.button).setOnClickListener(v -> {
            String nameText = name.getText().toString();
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();
            String repeatedPasswordText = repeatedPassword.getText().toString();

            // TODO - WE NEVER VALIDATED THE EMAIL NOR NAME:broken-heart:

            if (!passwordText.equals(repeatedPasswordText)) Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            else {
                Toast.makeText(this, "Successfully Registered!", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.registered);

                TextView providedName = findViewById(R.id.providedName);
                TextView providedEmail = findViewById(R.id.providedEmail);
                providedName.setText(nameText);
                providedEmail.setText(emailText);
            }
        });
    }
}