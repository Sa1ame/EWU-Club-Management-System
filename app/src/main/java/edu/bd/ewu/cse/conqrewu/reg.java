package edu.bd.ewu.cse.conqrewu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class reg extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText id, name, email, password;
    Button reg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        mAuth = FirebaseAuth.getInstance();
        id = findViewById(R.id.et1);
        name = findViewById(R.id.et2);
        email = findViewById(R.id.et3);
        password = findViewById(R.id.et4);
        reg = findViewById(R.id.btnreg);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }

            private void registerUser() {
                if (id.getText().toString().trim().isEmpty()) {
                    id.setError("Id is required");
                }
                if (name.getText().toString().trim().isEmpty()) {
                    name.setError("Name is required");
                }
                if (email.getText().toString().trim().isEmpty()) {
                    email.setError("Email is required");
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    email.setError("Enter a valid email");
                }
                if (password.getText().toString().trim().isEmpty()) {
                    password.setError("Password is required");
                }
                if (password.getText().toString().trim().length() < 6) {
                    password.setError("Minimum length is 6");
                }
                String rEmail = email.getText().toString().trim();
                String rPassword = password.getText().toString().trim();
                String rId = id.getText().toString().trim();
                String rName = name.getText().toString().trim();


                mAuth.createUserWithEmailAndPassword(rEmail, rPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(reg.this, "Registration Successful", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(reg.this, profile.class);
                            startActivity(intent);
                        }

                        else {
                            Toast.makeText(reg.this, "Registration Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }
        });


    }
}