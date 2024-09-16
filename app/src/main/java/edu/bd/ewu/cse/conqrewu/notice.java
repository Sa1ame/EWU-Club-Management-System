package edu.bd.ewu.cse.conqrewu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class notice extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    Button btn,btn2;
    DatabaseHelper3 mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        ed4=findViewById(R.id.ed4);
        btn=findViewById(R.id.Ndone);
        btn2=findViewById(R.id.Nview);
        mDatabaseHelper=new DatabaseHelper3(this);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Notification","Notify", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService((NotificationManager.class));
            manager.createNotificationChannel(channel);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry="";
                newEntry+="Notice Title: " + ed1.getText().toString() + "\n";
                newEntry+="Date: " + ed2.getText().toString() + "\n";
                newEntry+="Time: " + ed3.getText().toString() + "\n";
                newEntry+="About Notice: " + ed4.getText().toString() + "\n";


                if (newEntry.length() != 0) {
                    AddData(newEntry);
                } else {
                    toastMessage("You must put something in the text field!");
                }

                NotificationCompat.Builder builder = new NotificationCompat.Builder(notice.this,"Notification");
                builder.setContentTitle(ed1.getText().toString());
                builder.setContentText(ed4.getText().toString());
                builder.setSmallIcon(R.drawable.notice);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(notice.this);
                managerCompat.notify(1, builder.build());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(notice.this,ListNoticeActivity.class);
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