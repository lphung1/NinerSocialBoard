package com.example.ninerstudentorgboard;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        setTitle("Sign Up");


    }//end oncreate


    @Override
    protected void onStart() {
        super.onStart();

        final EditText fName = findViewById(R.id.fName_sign_up);
        final EditText lname = findViewById(R.id.lname_sign_up);
        final EditText email = findViewById(R.id.email_signup);
        final EditText password = findViewById(R.id.password_signup);
        final EditText confirmPassword = findViewById(R.id.password_confirm_signup);

        FirebaseUser currentUser = mAuth.getCurrentUser();




        findViewById(R.id.signup_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(lname.getText().toString().isEmpty() || fName.getText().toString().isEmpty() || password.getText().toString().isEmpty()
                        || email.getText().toString().isEmpty()){
                    Toast.makeText(SignUp.this, "Missing fields", Toast.LENGTH_LONG).show();
                    Log.d("missing fields", "Missing fields");
                }
                else{
                    if(password.getText().toString().contentEquals(confirmPassword.getText().toString())) {
                        SignUp();
                        finish();

                    }
                    else{
                        Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                        Log.d("password", "->" + password);
                        Log.d("password confirm", "->" + confirmPassword);
                    }
                }

            }
        });

        findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }//end onstart

    private void SignUp(){
        EditText fName = findViewById(R.id.fName_sign_up);
        EditText lname = findViewById(R.id.lname_sign_up);
        EditText email = findViewById(R.id.email_signup);
        EditText password = findViewById(R.id.password_signup);
        EditText confirmPassword = findViewById(R.id.password_confirm_signup);

        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("complete", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("complete", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });

    }//end signup
}
