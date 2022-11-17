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

public class inscription extends AppCompatActivity {
    EditText editTextUsername, editTextEmail, editTextPassword, editTextCnfPassword;
    Button buttonRegister;
    TextView textViewLogin;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        getSupportActionBar().hide();

        editTextUsername = findViewById(R.id.username);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.Password);
        editTextCnfPassword = findViewById(R.id.confirmPassword);
        buttonRegister = findViewById(R.id.register);
        textViewLogin = findViewById(R.id.login);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(inscription.this, sign.class));
            }
        });
        userDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUsername.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordConf = editTextCnfPassword.getText().toString().trim();

                if (password.equals(passwordConf)) {
                    Users user = new Users(userName,password,email,null);
                    userDao.insert(user);
                    Intent moveToLogin = new Intent(inscription.this, sign.class);
                    startActivity(moveToLogin);

                } else {
                    Toast.makeText(inscription.this, "Password is not matching", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}