package edu.bd.ewu.cse.conqrewu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class event2 extends AppCompatActivity {


    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Button btn,btn2;
    DatabaseHelper2 mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event2);

        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        ed4=findViewById(R.id.ed4);
        ed5=findViewById(R.id.ed5);
        ed6=findViewById(R.id.ed6);
        btn=findViewById(R.id.done);
        btn2=findViewById(R.id.view);
        mDatabaseHelper=new DatabaseHelper2(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry="";
                newEntry+="Event Title: " + ed1.getText().toString() + "\n";
                newEntry+="Time: " + ed2.getText().toString() + "\n";
                newEntry+="Date: " + ed3.getText().toString() + "\n";
                newEntry+="Place: " + ed4.getText().toString() + "\n";
                newEntry+="Club Name: " + ed5.getText().toString() + "\n";
                newEntry+="About Event: " + ed6.getText().toString() + "\n";

                if (newEntry.length() != 0) {
                    AddData(newEntry);
                } else {
                    toastMessage("You must put something in the text field!");
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(event2.this,ListEventActivity.class);
                startActivity(intent);
            }
        });

    }

    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}