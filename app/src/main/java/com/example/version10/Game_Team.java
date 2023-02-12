package com.example.version10;

public class Game_Team {

    private String score;
    private String team1;
    private String team2;
    private int id_athlimatos;


   public Game_Team(){ }

    public int getId_athlimatos() {
        return id_athlimatos;
    }

    public void setId_athlimatos(int id_athlimatos) {
        this.id_athlimatos = id_athlimatos;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }
}
