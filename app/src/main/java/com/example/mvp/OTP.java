package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTP extends AppCompatActivity {

    private EditText editTextMobile;
    private Button buttonContinue;
    String num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);
        editTextMobile = findViewById(R.id.editTextMobile);
        buttonContinue = findViewById(R.id.buttonContinue);

     buttonContinue.setOnClickListener(v -> {
         num= editTextMobile.getText().toString();
         validNum(num);
         Intent intent = new Intent(OTP.this, phoneverification.class);
         intent.putExtra("mobile", num);
         startActivity(intent);
         Toast.makeText(OTP.this, num, Toast.LENGTH_LONG).show();
     });

    }

    private void validNum(String num) {
        if (num.isEmpty() || num.length() < 10 ) {
            editTextMobile.setError("Enter a valid mobile");
            editTextMobile.requestFocus();
            return;
        }
    }


}