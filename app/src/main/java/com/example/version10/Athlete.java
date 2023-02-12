package com.example.version10;
//THIS IS THE PROBLEM

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "athletes",
        primaryKeys = {"athlete_id"},
        foreignKeys = {
        @ForeignKey(entity = Sport.class,
                parentColumns = "sport_id",
                childColumns = "athlete_sport_id",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)})

public class Athlete {

    @ColumnInfo(name="athlete_id")
    private int id;

    @ColumnInfo(name="athlete_name")
    private String name;

    @ColumnInfo(name="athlete_surname")
    private String surname;

    @ColumnInfo(name="athlete_city")
    private String city;

    @ColumnInfo(name="athlete_country")
    private String country;

    @ColumnInfo(name="athlete_sport_id")
    private int sport_id;

    @ColumnInfo(name="athlete_birth_date")
    private String birth_date;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getSport_id() {
        return sport_id;
    }
    public void setSport_id(int sport_id) {
        this.sport_id = sport_id;
    }
    public String getBirth_date() {
        return birth_date;
    }
    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }
}
