package com.example.cosu_pra;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";
    EditText editTextLoginEmail;
    EditText editTextLoginPassword;
    Button buttonSignin;
    TextView textviewSignup;
    TextView textviewMessage;
    TextView textviewFindPassword;
    private TextView tvLogin;
    private TextView tvToYourAccount;
    ProgressDialog progressDialog;
    //define firebase object
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();//use firebase get instance

        if (firebaseAuth.getCurrentUser() != null) {
            //if already logged in
            finish();//finish and go to Main activity

            startActivity(new Intent(getApplicationContext(), MainActivity.class)); //
        }
        editTextLoginEmail = (EditText) findViewById(R.id.editTextLoginEmail);
        editTextLoginPassword = (EditText) findViewById(R.id.editTextLoginPassword);
        textviewSignup = (TextView) findViewById(R.id.textViewSignUp);
        textviewMessage = (TextView) findViewById(R.id.textviewMessage);
        textviewFindPassword = (TextView) findViewById(R.id.textViewFindPassword);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        tvToYourAccount = (TextView) findViewById(R.id.tvToYourAccount);

        buttonSignin = (Button) findViewById(R.id.buttonLogIn);
        progressDialog = new ProgressDialog(this); //conncect Function


        tvLogin.setText("Log in");
        tvToYourAccount.setText(" to your Account");
//        button click event
        buttonSignin.setOnClickListener(this);
        textviewSignup.setOnClickListener(this);
        textviewFindPassword.setOnClickListener(this);
    }

    private void userLogin() {
        String email = editTextLoginEmail.getText().toString().trim();
        String password = editTextLoginPassword.getText().toString().trim();
        //get identification

        /* *******Validation ref:http://blog.naver.com/suda552/220813122485******** */


        /* *******Validation of email(is empty& validation)******** */
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please input E-mail.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Not in email format\n", Toast.LENGTH_SHORT).show();
            return;
        }
        /* *******Validation of email(is empty& validation)******** */

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please input password.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$", password))
        {
            Toast.makeText(this,"Please keep the password format.",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Logging in. wait a moment please...");
        progressDialog.show();

        //logging in the user
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Login Failed! Please try again", Toast.LENGTH_LONG).show();
                            textviewMessage.setText("Passwords must consist of numbers, alphabets, \nand special symbols.\nPassword must be \nat least 8 characters long\n");
                        }
                    }
                });
    }


    @Override
    public void onClick(View view) {

        /* *******if click Login button , can login ******** */
        if (view == buttonSignin) {
            userLogin();
        }
        /* *******if click Signup button , can Signup ******** */

        if (view == textviewSignup) {
            startActivity(new Intent(this, SignupActivity.class));
        }
        /* *******go to find password ******** */

        if (view == textviewFindPassword) {
            startActivity(new Intent(this, FindActivity.class));
        }
    }
}