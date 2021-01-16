package com.anStudios.bookingstats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText registerEmail;
    private EditText registerPassword;
    private EditText registerName;
    private ProgressBar progressBar;
    private Button registerbtn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        registerbtn=findViewById(R.id.signup_btn);
        registerName=findViewById(R.id.register_name);
        mAuth=FirebaseAuth.getInstance();
        registerEmail=findViewById(R.id.register_mail);
        progressBar=findViewById(R.id.register_progressbar);
        registerPassword=findViewById(R.id.register_password);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEmailAndPasswordOffline(registerEmail.getText().toString(),registerPassword.getText().toString(),registerName.getText().toString())){
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.createUserWithEmailAndPassword(registerEmail.getText().toString(),registerPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(SignUpActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUpActivity.this,HomeScreen.class));
                                overridePendingTransition(R.anim.slide_next, R.anim.slide_down);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private boolean checkEmailAndPasswordOffline(String email, String password, String name) {
        boolean temp = true;
        if(!email.equals("") && !password.equals("") && !name.equals("")){
            if(!email.endsWith("@gmail.com")){
                temp=false;
                Toast.makeText(this, "Please provide a valid Gmail Account", Toast.LENGTH_SHORT).show();
            }else if(password.length()<6){
                temp=false;
                Toast.makeText(this, "Please Set Up a Strong Password", Toast.LENGTH_SHORT).show();
            }else if(!name.contains(" ")){
                temp=false;
                Toast.makeText(this, "You name cannot be of one word", Toast.LENGTH_SHORT).show();
            }
        }else{
            temp=false;
            Toast.makeText(this, "Please Fill Al The Fields", Toast.LENGTH_SHORT).show();
        }
        return temp;
    }

}