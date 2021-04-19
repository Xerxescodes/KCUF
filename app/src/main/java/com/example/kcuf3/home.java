package com.example.kcuf3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater xer = getMenuInflater();
        xer.inflate(R.menu.profile,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int xerxes = item.getItemId();
        switch(xerxes){
            case R.id.action_call:
                Intent s = new Intent(home.this,caller.class);
                startActivity(s);
                return true;
            case R.id.action_sendmail:
                Intent x = new Intent(home.this,mail.class);
                startActivity(x);
                return true;
            case R.id.action_search:
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}