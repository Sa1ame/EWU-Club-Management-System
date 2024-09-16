package edu.bd.ewu.cse.conqrewu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class club extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

    }
    public void btn1(View v){

        Intent i= new Intent(club.this,agro.class);
        startActivity(i);
    }

    public void btn2(View v){

        Intent i= new Intent(club.this,bClub.class);
        startActivity(i);
    }

    public void btn3(View v){

        //Intent i= new Intent(club.this,notice.class);
        //startActivity(i);

    }

    public void btn4(View v){

       // Intent i= new Intent(club.this,blood.class);
       //startActivity(i);
    }


    public void btn5(View v){

        //Intent i= new Intent(club.this,contact.class);
        //startActivity(i);

    }

    public void btn6(View v){

        // Intent i= new Intent(club.this,blood.class);
        //startActivity(i);
    }

    public void btn7(View v){

        Intent i= new Intent(club.this,contact.class);
        startActivity(i);
    }

}