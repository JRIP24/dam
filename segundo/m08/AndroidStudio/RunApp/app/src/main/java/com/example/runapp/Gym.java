package com.example.runapp;

public class Gym {

    private String classType;
    private String trainer;
    private String date;
    private String time;
    private int image0;
    private int[] images;
    private String description;
    private String kCal;
    private String duration;
    private String room;

    public Gym(String classType, String trainer, String date, String time, int image0, int[] images, String description, String kCal, String duration, String room) {
        this.classType = classType;
        this.trainer = trainer;
        this.date = date;
        this.time = time;
        this.image0 = image0;
        this.images = images;
        this.description = description;
        this.kCal = kCal;
        this.duration = duration;
        this.room = room;
    }

    public String getClassType() {
        return classType;
    }

    public String getTrainer() {
        return trainer;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getImage0() {
        return image0;
    }

    public int[] getImages() {
        return images;
    }

    public String getDescription() {
        return description;
    }

    public String getkCal() {
        return kCal;
    }

    public String getDuration() {
        return duration;
    }

    public String getRoom() {
        return room;
    }
}
