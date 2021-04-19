package com.example.kcuf3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class caller extends AppCompatActivity {
    EditText editText1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller);

        initViews();
    }

    public void caller(View view){
      String number = editText1.getText().toString();
        Intent callintent = new Intent(Intent.ACTION_CALL);
        callintent.setData(Uri.parse("tel:"+number));
        startActivity(callintent);
    }

    private void initViews(){
        editText1 = findViewById(R.id.edttxt);
        btn = findViewById(R.id.btncall);
    }
}