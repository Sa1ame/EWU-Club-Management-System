package edu.bd.ewu.cse.conqrewu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView register;
    EditText LEmail,LPassword;
    Button Login;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register = findViewById(R.id.reg);
        LEmail = findViewById(R.id.let1);
        LPassword = findViewById(R.id.let2);
        Login = findViewById(R.id.loginBtn);
        fAuth=FirebaseAuth.getInstance();



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,reg.class);
                startActivity(intent);
            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String LoginEmail = LEmail.getText().toString().trim();
                String LoginPassword = LPassword.getText().toString().trim();

                if (LoginEmail.isEmpty()) {
                    LEmail.setError("Email is required");
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(LoginEmail).matches()) {
                    LEmail.setError("Enter a valid email");
                }
                if (LoginPassword.isEmpty()) {
                    LPassword.setError("Password is required");
                }
                if (LoginPassword.length() < 6) {
                    LPassword.setError("Minimum length is 6");
                }
                fAuth.signInWithEmailAndPassword(LoginEmail,LoginPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful() && LoginEmail.equals("admin@gmail.com")) {
                            Toast.makeText(MainActivity.this, "Logged in Successfully As Admin", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, admin.class));
                        }
                        else if (task.isSuccessful() && !LoginEmail.equals("admin@gmail.com")) {
                            Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, profile.class));
                        }

                        else {
                            Toast.makeText(MainActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                SharedPreferences sf = getSharedPreferences("demo", MODE_PRIVATE);
                SharedPreferences.Editor editor = sf.edit();


                editor.putString("email", LoginEmail);

                editor.apply();
                LEmail.setText(LoginEmail);
            }
        });
        SharedPreferences getShared = getSharedPreferences("demo", MODE_PRIVATE);
        String value = getShared.getString("email","Nothing is here");


        LEmail.setText(value);

    }

}