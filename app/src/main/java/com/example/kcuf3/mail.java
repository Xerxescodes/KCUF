package com.example.kcuf3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mail extends AppCompatActivity implements View.OnClickListener {
EditText textview1,textview2,textview3;
Button sndbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        initViews();

        sndbtn.setOnClickListener(this);
    }

    private void initViews(){
        textview1 = findViewById(R.id.edittext1);
        textview2 = findViewById(R.id.edittext2);
        textview3 = findViewById(R.id.edittext3);

        sndbtn = findViewById(R.id.sendbtn);
    }

    @Override
    public void onClick(View v) {
        String  to = textview1.getText().toString();
        String  subject = textview2.getText().toString();
        String  message = textview3.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);

        email.putExtra(Intent.EXTRA_EMAIL,new String[] {to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email,"Choose Email Client:"));
    }
}