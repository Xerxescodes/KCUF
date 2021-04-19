package com.example.kcuf3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = " MainActivity";

    private EditText edttxtName,edttxtEmail,edttxtPassword,edttxtRepassword;
    private Button register;
    private TextView txtwarnName,txtwarnEmail,txtwarnPassword,txtwarnRepassword;
    private RadioGroup rgp;
    private Spinner locations;
    private ImageView img;
    static int PRegCode=1;
    static int REQUESCODE=1;
    Uri pickedimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= 20){
                    checkpermissionrequest();
                }else {
                    opengallery();
                }
            }
        });
    }

    private void opengallery() {
        Intent galleryintent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryintent.setType("image/*");
        startActivityForResult(galleryintent,REQUESCODE);
    }

    private void checkpermissionrequest() {
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)){

                Toast.makeText(this,"Please accept required permission",Toast.LENGTH_SHORT).show();
            }else{
                 ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission
                 .READ_EXTERNAL_STORAGE},PRegCode);
            }
        }else
            opengallery();
    }

    public void initviews() {
        Log.d(TAG, "initViews: Started");

        edttxtEmail = findViewById(R.id.email);
        edttxtName = findViewById(R.id.name);
        edttxtPassword = findViewById(R.id.opswd);
        edttxtRepassword = findViewById(R.id.rpswd);

        rgp = findViewById(R.id.gender);

        register = findViewById(R.id.rgbtn);
        txtwarnEmail = findViewById(R.id.emailtxt);
        txtwarnName = findViewById(R.id.nametxt);
        txtwarnPassword = findViewById(R.id.opsw);
        txtwarnRepassword = findViewById(R.id.pswd);

        img = findViewById(R.id.userimg);
    }

    public void nasclicked(View view) {
        Intent intent = new Intent(MainActivity.this,login.class);
        startActivity(intent);
    }

    private void initRegister() {
        Log.d(TAG, "initRegister: Started");

        if (validateData()) {
            ShowSnackbar();
            Toast.makeText(this,"Registeration successful",Toast.LENGTH_SHORT).show();
            Intent inter = new Intent(MainActivity.this,login.class);
            startActivity(inter);
        } else {
            Toast.makeText(this, "Registeration incomplete", Toast.LENGTH_SHORT).show();
        }
    }

    private void ShowSnackbar(){
        Log.d(TAG,"ShowSnackbar: Started");

        txtwarnName.setVisibility(View.GONE);
        txtwarnEmail.setVisibility(View.GONE);
        txtwarnRepassword.setVisibility(View.GONE);
        txtwarnPassword.setVisibility(View.GONE);

        //retrieve user information
        //txtwarnEmail.getText().toString
        edttxtEmail.setText("");
        edttxtName.setText("");
        edttxtPassword.setText("");
        edttxtRepassword.setText("");

    }

    private boolean validateData(){
        if(edttxtName.getText().toString().equals("")){
            txtwarnName.setVisibility(View.VISIBLE);
            txtwarnName.setText("Enter your name");
            return false;
        }

        if(edttxtEmail.getText().toString().equals("")){
            txtwarnEmail.setVisibility(View.VISIBLE);
            txtwarnEmail.setText("Enter your email");
            return false;
        }

        if(edttxtRepassword.getText().toString().equals("")){
            txtwarnRepassword.setVisibility((View.VISIBLE));
            txtwarnRepassword.setText("Renter renter password");
            return false;
        }

        if(edttxtPassword.getText().toString().equals("")){
            txtwarnPassword.setVisibility((View.VISIBLE));
            txtwarnPassword.setText("Renter password");
            return false;
        }

        if(!edttxtRepassword.getText().toString().equals(edttxtPassword.getText().toString())){
            txtwarnPassword.setVisibility((View.VISIBLE));
            txtwarnPassword.setText("Password Mismatch");
            return false;
        }

        return true;
    }

    public void clicked(View view) {
    }

    public void xerclicked(View view) {
        initRegister();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == REQUESCODE &&data != null){
            pickedimg = data.getData();
            img.setImageURI(pickedimg);
        }
    }
}