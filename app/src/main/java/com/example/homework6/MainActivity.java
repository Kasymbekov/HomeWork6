package com.example.homework6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email_input = findViewById(R.id.gmail_input);
        EditText pass_input = findViewById(R.id.pass_input);
        Button btn = findViewById(R.id.enter_btn);

        Resources res = getResources();
        int main = res.getColor(R.color.grey);
        int extra = res.getColor(R.color.orange);

        pass_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (email_input.getText().toString().length() > 0 && pass_input.getText().toString().length() > 0) {
                    btn.setBackgroundColor(extra);
                } else {
                    btn.setBackgroundColor(main);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btn.setOnClickListener(view -> {
            String email = email_input.getText().toString();
            String pass = pass_input.getText().toString();
            if (email.length() > 0 && pass.length() > 0) {
                if (email.matches("admin") && pass.matches("admin")) {
                    findViewById(R.id.sign_in).setVisibility(View.INVISIBLE);
                    findViewById(R.id.desc).setVisibility(View.INVISIBLE);
                    findViewById(R.id.gmail_input).setVisibility(View.INVISIBLE);
                    findViewById(R.id.pass_input).setVisibility(View.INVISIBLE);
                    findViewById(R.id.enter_btn).setVisibility(View.INVISIBLE);
                    findViewById(R.id.forgot_pass).setVisibility(View.INVISIBLE);
                    Toast.makeText(this, "Авторизация прошла успешно!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Неправильный логин или пароль! Повторите попытку.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}