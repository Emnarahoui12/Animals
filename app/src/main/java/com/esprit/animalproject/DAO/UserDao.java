package com.esprit.animalproject.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.esprit.animalproject.Entity.Users;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM Users where email= :mail and password= :password")
    Users getUser(String mail, String password);

    @Insert
    void insert(Users user);

    @Update
    void update(Users user);

    @Delete
    void delete(Users user);

    @Query("SELECT * FROM Users")
    List<Users> getAllUsers();
}
