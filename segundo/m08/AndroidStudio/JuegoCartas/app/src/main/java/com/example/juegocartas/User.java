package com.example.juegocartas;

public class User {

    int globalScore;
    double points;
    int numCartas;
    boolean isBank;

    public User(){

        this.globalScore = 0;
        this.points = 0.0;
        this.numCartas = 0;
        this.isBank = false;

    }

    public User(int globalScoreP, double pointsP, int numCartasP, boolean isBankP){

        this.globalScore = globalScoreP;
        this.points = pointsP;
        this.numCartas = numCartasP;
        this.isBank = isBankP;

    }


}
