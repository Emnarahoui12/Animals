package com.esprit.animalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.esprit.animalproject.DAO.UserDao;
import com.esprit.animalproject.DataBase.UserDataBase;
import com.esprit.animalproject.Entity.CustomListAdapter;
import com.esprit.animalproject.Entity.Users;

import java.util.ArrayList;
import java.util.List;

public class Veterinary extends AppCompatActivity {

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinary);
        getSupportActionBar().hide();

        List<Users> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Users user = (Users) o;
                Toast.makeText(Veterinary.this, "Selected :" + " " + user, Toast.LENGTH_LONG).show();
            }
        });
    }
    private  List<Users> getListData() {
        List<Users> list = new ArrayList<>();
        Users vet1 = new Users("Asma rahoui","asma", "asma@gmail.com","vet1");
        Users vet2 = new Users("mohamed sdiri","mohamed", "mohamed@gmail.com","vet2");
        Users vet3 = new Users("Siwar chamekh","siwar", "siwar@gmail.com","vet3");


        list.add(vet1);
        list.add(vet2);
        list.add(vet3);

        return list;


    }
}