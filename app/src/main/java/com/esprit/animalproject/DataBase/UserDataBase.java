package com.esprit.animalproject.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.esprit.animalproject.DAO.UserDao;
import com.esprit.animalproject.Entity.Users;

@Database(entities = {Users.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {
    private static UserDataBase instance;
    public abstract UserDao getUserDao();
    public static UserDataBase getDatabase(Context ctx) {
        if (instance == null) {
            instance = Room.databaseBuilder(ctx.getApplicationContext(), UserDataBase.class, "db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;}

}
