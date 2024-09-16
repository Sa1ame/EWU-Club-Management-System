package edu.bd.ewu.cse.conqrewu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);



    }
    public void btn1(View v){

        Intent i= new Intent(admin.this,club2.class);
        startActivity(i);
    }

    public void btn2(View v){

        Intent i= new Intent(admin.this,event2.class);
        startActivity(i);
    }


    public void btn3(View v){

         Intent i= new Intent(admin.this,notice.class);
         startActivity(i);
    }

    public void btn4(View v){
        // Intent i= new Intent(admin.this,blood.class);
        //startActivity(i);
    }


    public void btn5(View v){
        //Intent i= new Intent(admin.this,comtact.class);
        //startActivity(i);
    }
}