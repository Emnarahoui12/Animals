package com.esprit.animalproject.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Animal {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String name;
    private String specie;
    private String gender ;
    private Date birthday;
    private String breed ;
    private String color ;
    private Float wieght ;
    private String vaccine ;
    private String symptoms ;
    private String prescription ;




}
