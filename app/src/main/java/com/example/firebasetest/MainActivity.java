package com.example.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editTextName,editTextEmail,editTextPassword;
    Button button;
    private FirebaseAuth mAuth;
    DatabaseReference reference;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("User");
        button = (Button) findViewById(R.id.button);
        user=new User();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(editTextName.getText().toString().trim());
                user.setEmail(editTextEmail.getText().toString().trim());
                user.setPassword(editTextPassword.getText().toString().trim());

                reference.push().setValue(user);
                Toast.makeText(MainActivity.this, "Inserted successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
