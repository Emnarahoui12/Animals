package com.esprit.animalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.esprit.animalproject.DAO.UserDao;
import com.esprit.animalproject.DataBase.UserDataBase;
import com.esprit.animalproject.Entity.Users;

public class sign extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    TextView textViewRegister;
    UserDao db;
    UserDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        getSupportActionBar().hide();


        editTextEmail = findViewById(R.id.emaillogin);
        editTextPassword = findViewById(R.id.Passwordlogin);
        buttonLogin = findViewById(R.id.buttonlogin);

        textViewRegister = findViewById(R.id.textViewRegister);

        dataBase = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sign.this, inscription.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                Users user = db.getUser(email, password);
                if (user != null) {
                    Intent i = new Intent(sign.this, Home.class);
                   // i.putExtra("Users", user);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(sign.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}