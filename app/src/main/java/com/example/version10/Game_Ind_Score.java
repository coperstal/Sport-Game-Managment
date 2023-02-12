package com.example.version10;

public class Game_Ind_Score {

    private int id1;
    private int id2;
    private String score;
    private int id_athlimatos;


    public Game_Ind_Score(){}

    public int getId1() {
        return id1;
    }

    public int getId_athlimatos() {
        return id_athlimatos;
    }

    public void setId_athlimatos(int id_athlimatos) {
        this.id_athlimatos = id_athlimatos;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
