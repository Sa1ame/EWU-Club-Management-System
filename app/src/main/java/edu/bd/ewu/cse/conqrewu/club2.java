package edu.bd.ewu.cse.conqrewu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class club2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club2);
    }


    public void btn1(View v){

        Intent i= new Intent(club2.this,ListDataActivity.class);
        startActivity(i);
    }

    public void btn2(View v){

        Intent i= new Intent(club2.this,ListDataActivity.class);
        startActivity(i);
    }

    public void btn3(View v){

        //Intent i= new Intent(admin_club.this,notice.class);
        //startActivity(i);

    }

    public void btn4(View v){

        //Intent i= new Intent(admin_club.this,blood.class);
        //startActivity(i);
    }


    public void btn5(View v){
        //Intent i= new Intent(admin_club.this,comtact.class);
        //startActivity(i);

    }




}