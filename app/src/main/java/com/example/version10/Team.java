package com.example.version10;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "teams",
        primaryKeys = {"team_id"},
        foreignKeys = {
                @ForeignKey(entity = Sport.class,
                            parentColumns ="sport_id",
                            childColumns = "team_sport_id",
                            onDelete = ForeignKey.CASCADE,
                            onUpdate = ForeignKey.CASCADE)})

public class Team {

    @ColumnInfo(name="team_id")
    private  int id;

    @ColumnInfo(name="team_name")
    private String name;

    @ColumnInfo(name="team_field_name")
    private String field_name;

    @ColumnInfo(name="team_city")
    private String team_city;

    @ColumnInfo(name="team_country")
    private String team_country;

    @ColumnInfo(name="team_year")
    private String team_year;

    @ColumnInfo(name="team_sport_id")
    private int team_sport_id;


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
    public String getField_name() {
        return field_name;
    }
    public void setField_name(String field_name) {
        this.field_name = field_name;
    }
    public String getTeam_city() {
        return team_city;
    }
    public void setTeam_city(String team_city) {
        this.team_city = team_city;
    }
    public String getTeam_country() {
        return team_country;
    }
    public void setTeam_country(String team_country) {
        this.team_country = team_country;
    }
    public String getTeam_year() {
        return team_year;
    }
    public void setTeam_year(String team_year) {
        this.team_year = team_year;
    }
    public int getTeam_sport_id() {
        return team_sport_id;
    }
    public void setTeam_sport_id(int team_sport_id) {
        this.team_sport_id = team_sport_id;
    }
}
