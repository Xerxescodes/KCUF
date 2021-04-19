package com.example.kcuf3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private static final String TAG = " login";
EditText text1,text2;
TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    public void xerclick(View view){
     System.exit(1);
    }

    public void initViews(){
       text1 = findViewById(R.id.name);
       text2 = findViewById(R.id.passworder);
       txt1 = findViewById(R.id.namer);
    }

    public boolean validateLogin(){
        if(text1.getText().toString().equals("")&&text2.getText().toString().equals(""))
        {
            txt1.setVisibility(View.VISIBLE);
            txt1.setText("Fill All Fields");
            return false;
        }
        return true;
    }

    private void ShowSnackbar(){
        Log.d(TAG,"ShowSnackbar: Started");
        txt1.setVisibility(View.GONE);
        //retrieve user information
        //txtwarnEmail.getText().toString
        text1.setText("");
        text2.setText("");
    }

    public void clicker(View view) {
        if (validateLogin()) {
            ShowSnackbar();
            Toast.makeText(this, "Login Succesfull", Toast.LENGTH_SHORT).show();
            Intent intr = new Intent(login.this, home.class);
            startActivity(intr);
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}