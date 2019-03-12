package com.example.ninerstudentorgboard;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private int RC_SIGN_IN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        setTitle("Sign Up");

        findViewById(R.id.google_sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }


        });



    }//end oncreate

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("Activity Result:", "Started activity result");
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Log.d("Activity Result:", "Login Good");
            Log.d("Activity Result:", "request code - " + requestCode);
            Log.d("Activity Result:", "RC_SIGN_IN -" + RC_SIGN_IN);
            Intent i = new Intent(SignUp.this, MainActivity.class);
            startActivity(i);
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

//
//        final EditText fName = findViewById(R.id.enter_uncc_email_edit_text);
//        final EditText lname = findViewById(R.id.lname_sign_up);
//        final EditText email = findViewById(R.id.email_signup);
//        final EditText password = findViewById(R.id.password_signup);
//        final EditText confirmPassword = findViewById(R.id.password_confirm_signup);
//
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//
//        findViewById(R.id.signup_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(lname.getText().toString().isEmpty() || fName.getText().toString().isEmpty() || password.getText().toString().isEmpty()
//                        || email.getText().toString().isEmpty()){
//                    Toast.makeText(SignUp.this, "Missing fields", Toast.LENGTH_LONG).show();
//                    Log.d("missing fields", "Missing fields");
//                }
//                else{
//                    if(password.getText().toString().contentEquals(confirmPassword.getText().toString())) {
//                        SignUp();
//                        finish();
//
//                    }
//                    else{
//                        Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_LONG).show();
//                        Log.d("password", "->" + password);
//                        Log.d("password confirm", "->" + confirmPassword);
//                    }
//                }
//
//            }
//        });




    }//end onstart


    //reference code
//    private void SignUp(){
//        EditText fName = findViewById(R.id.enter_uncc_email_edit_text);
//        EditText lname = findViewById(R.id.lname_sign_up);
//        EditText email = findViewById(R.id.email_signup);
//        EditText password = findViewById(R.id.password_signup);
//        EditText confirmPassword = findViewById(R.id.password_confirm_signup);
//
//        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d("complete", "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            //updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w("complete", "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(SignUp.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            //updateUI(null);
//                        }
//
//                        // ...
//                    }
//                });
//
//    }//end signup

    private void signIn() {
        Log.d("Signin Function ", "starting signin intent function");
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {

        Log.d("Handle SignInResult:", "Function Started");
        Log.d("Handle SignInResult:", "Task" + completedTask);

        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Log.d("Handle SignInResult:", "Login Good, starting intent");
            Intent i = new Intent(SignUp.this, MainActivity.class);
            startActivity(i);
            // Signed in successfully, show authenticated UI.
           // updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            //Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }


}
