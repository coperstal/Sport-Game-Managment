package com.example.version10;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface dao {
  //ROOMUI_QUERIES
  @Query("select * from athletes where athlete_id=2")
  public List<Athlete> getQuery11();

  @Query("select * from teams where team_id=8")
  public List<Team> getQuery22();

  @Query("select * from sports where sport_id=1")
  public List<Sport> getQuery33();

  //Search
  @Query("select athlete_name as field1,athlete_surname as field2,team_name as field3," +
          " sport_name as field4,sport_gender as field5 from teams inner join " +
          "sports on team_sport_id=sport_id inner join athletes on athlete_sport_id=sport_id")
  public List<ResultStringInt>getQuery2();

  @Query("select athlete_id as field1,athlete_name as field2,athlete_surname as field3,athlete_birth_date"
          + " as field4,sport_name as field5," +
          "sport_team as field6 from athletes inner join sports on athlete_sport_id=sport_id")
  public List<ResultStringInt>getQuery3();

  //Athlete
  @Delete  public void deleteAthlete(Athlete athlete);
  @Update public void updateAthlete(Athlete athlete);
  @Insert  public void AddAthlete(Athlete athlete);
  @Query("select * from athletes")  public List<Athlete> getAthletes();

  //Sport
  @Update void UpdateSport (Sport sport);
  @Insert  public void AddSport(Sport sport);
  @Delete  public void deleteSport(Sport sport);
  @Query("select * from sports")  public List<Sport> getSports();

  //Team
  @Insert  public void AddTeam(Team team);
  @Delete  public void deleteTeam(Team team);
  @Update public void UpdateTeam(Team team);
  @Query("select * from teams")  public List<Team> getTeams();
}
