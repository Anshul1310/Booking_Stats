package com.anStudios.bookingstats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText loginemailAddress;
    private EditText loginPassword;
    private Button loginBtn;
    private ProgressBar progressBar;
    private TextView ForgotPassword;
    private TextView signUpbtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn = findViewById(R.id.login_btn);
        loginemailAddress = findViewById(R.id.login_email);
        progressBar=findViewById(R.id.login_progressbar);
        loginPassword = findViewById(R.id.login_password);
        mAuth = FirebaseAuth.getInstance();
        ForgotPassword = findViewById(R.id.go_to_forgetPassword);
        signUpbtn = findViewById(R.id.gotoregisterpage);
        signUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                overridePendingTransition(R.anim.slide_next, R.anim.slide_down);
            }
        });

        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPassword.class));
                overridePendingTransition(R.anim.slide_next, R.anim.slide_down);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkEmailAndPasswordOffline(loginemailAddress.getText().toString(), loginPassword.getText().toString())) {
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(loginemailAddress.getText().toString(),
                            loginPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                progressBar.setVisibility(View.INVISIBLE);
                                startActivity(new Intent(LoginActivity.this,HomeScreen.class));
                                overridePendingTransition(R.anim.slide_next, R.anim.slide_down);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    //To Check Email And Password's length and to ensure whther they meet a certain criteria
    private boolean checkEmailAndPasswordOffline(String email, String password) {
        boolean temp = true;
        if (!email.equals("") && !password.equals("")) {
            if (!email.endsWith("@gmail.com") || password.length() < 6) {
                temp = false;
                Toast.makeText(this, "Invalid Username Or Password", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please Fill All The Fields", Toast.LENGTH_SHORT).show();
            temp = false;
        }
        return temp;
    }
}