package com.example.validadateemail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editEmail;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);

        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmail();
            }
        });
    }

    private boolean validateEmail(){
        String email = editEmail.getText().toString().trim();

        if (email.isEmpty()){
            editEmail.setError("campos nao pode ser vazio");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("por favor digite um e-mail valido");
            return false;
        }else {
            editEmail.setError(null);
            return true;
        }
    }
}
