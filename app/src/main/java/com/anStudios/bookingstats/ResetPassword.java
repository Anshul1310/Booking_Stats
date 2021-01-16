package com.anStudios.bookingstats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    private EditText resetEmail;
    private Button resetPasswordbtn;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        resetPasswordbtn=findViewById(R.id.reset_password_btn);
        mAuth=FirebaseAuth.getInstance();
        resetEmail=findViewById(R.id.reset_password_mail);
        progressBar=findViewById(R.id.reset_progress_bar);
        resetPasswordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!resetEmail.getText().toString().endsWith("@gmail.com")){
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.sendPasswordResetEmail(resetEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(ResetPassword.this, "Check You Inbox to Reset Your Password", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ResetPassword.this,LoginActivity.class));
                                overridePendingTransition(R.anim.slide_next, R.anim.slide_down);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(ResetPassword.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(ResetPassword.this, "Please provide a valid Gmail Account", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}