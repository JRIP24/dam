package com.example.spinner;

public class DavidBowie {

    private String coverName;
    private int imgCover;

    public DavidBowie(String coverName, int imgCover) {
        this.coverName = coverName;
        this.imgCover = imgCover;
    }

    public String getCoverName() {
        return coverName;
    }

    public int getImgCover() {
        return imgCover;
    }


    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    public void setImgCover(int imgCover) {
        this.imgCover = imgCover;
    }
}
