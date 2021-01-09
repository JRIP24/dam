package com.example.juegocartas;

public class User {

    int globalScore;
    double points;
    int numCartas;
    boolean isBank;

    public User(int globalScoreP, double pointsP, int numCartasP, boolean isBankP){

        this.globalScore = globalScoreP;
        this.points = pointsP;
        this.numCartas = numCartasP;
        this.isBank = isBankP;

    }


}
