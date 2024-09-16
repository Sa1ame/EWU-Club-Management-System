package edu.bd.ewu.cse.conqrewu;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;

public class profile extends AppCompatActivity {

    private Button btn;
    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        btn=findViewById(R.id.back);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                finish();
            }
        });


    }
    public void btn1(View v){

        Intent i= new Intent(profile.this,club.class);
        startActivity(i);
    }

    public void btn2(View v){

        Intent i= new Intent(profile.this,ListEventActivity.class);
        startActivity(i);
    }


    public void btn3(View v){

        Intent i= new Intent(profile.this,ListNoticeActivity.class);
        startActivity(i);
    }

    public void btn4(View v){
        //Intent i= new Intent(profile.this,blood.class);
        //startActivity(i);
    }


    public void btn5(View v){
        Intent i= new Intent(profile.this,contact.class);
        startActivity(i);
    }




}