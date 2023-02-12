package com.example.version10;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Sport.class, Athlete.class,Team.class}, version = 4, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract dao myDao();

}
