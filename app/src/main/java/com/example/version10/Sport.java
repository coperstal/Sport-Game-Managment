package com.example.version10;

import androidx.room.ColumnInfo;
import  androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


/*
  @Entity (tableName="sport",
        primaryKeys = {"sports_id"},
        foreignKeys = {
                @ForeignKey(entity =Athlete.class,
                        parentColumns = "athlete_id",
                        childColumns = "sports_id",
                        onDelete= ForeignKey.CASCADE,
                        onUpdate=ForeignKey.CASCADE)})


*/

@Entity (tableName="sports")

public class Sport {

    @PrimaryKey
    @ColumnInfo(name="sport_id")
    private  int id;
    @ColumnInfo(name="sport_name")
    private String name;
    @ColumnInfo(name="sport_team")
    private String team; //If 1 = individual sport Else if 2 = team sport
    @ColumnInfo(name="sport_gender")
    private String gender; //female or male
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}
