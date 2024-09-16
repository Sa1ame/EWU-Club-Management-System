package edu.bd.ewu.cse.conqrewu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class join extends Activity {
    private EditText r1,r2,r3,r4,r5,r6;
    private Button btn,btn2;
    FirebaseFirestore firestore;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        r4=findViewById(R.id.r4);
        r5=findViewById(R.id.r5);
        r6=findViewById(R.id.r6);
        btn=findViewById(R.id.b1);
        //btn2=findViewById(R.id.b2);
        firestore = FirebaseFirestore.getInstance();
        mDatabaseHelper=new DatabaseHelper(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String errorMsg = "";

                if(r1.length()<3){
                    errorMsg += "Invalid Name \n";
                }
                if(r2.length()<3){
                    errorMsg += "Invalid id \n";
                }
                if(r3.length()<3){
                    errorMsg += "Invalid email \n";
                }
                if(r4.length()<3){
                    errorMsg += "Invalid dept \n";
                }
                if(r5.length()<3){
                    errorMsg += "Invalid clubname \n";
                }

                if(errorMsg.length()==0) {
                    showDialog("Are you sure you want to register?","success","Yes","No");
                }
                else{

                    showDialog(errorMsg,"Error","back","ok");
                }


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




    public void showDialog(String message,String title,String btn1,String btn2){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);

        builder.setCancelable(false)
                .setPositiveButton(btn1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Util.getInstance().deleteByKey(MainActivity.this,key);
                        dialog.cancel();
                        //loadData();
                        // adapter.notifydataSetChanged();
                        String newEntry="";
                        newEntry+="Name: " + r1.getText().toString() + "\n";
                        newEntry+="Id: " + r2.getText().toString() + "\n";
                        newEntry+="Email: " + r3.getText().toString() + "\n";
                        newEntry+="Department: " + r4.getText().toString() + "\n";
                        newEntry+="Club Name: " + r5.getText().toString() + "\n";
                        newEntry+="Reason: " + r6.getText().toString() + "\n";

                        if (newEntry.length() != 0) {
                            AddData(newEntry);
                        } else {
                            toastMessage("You must put something in the text field!");
                        }
                        btn.setVisibility(View.GONE);
                        Intent i= new Intent(join.this,regSuccess.class);
                        startActivity(i);
                    }
                })
                .setNegativeButton(btn2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert=builder.create();
        alert.show();
    }



}