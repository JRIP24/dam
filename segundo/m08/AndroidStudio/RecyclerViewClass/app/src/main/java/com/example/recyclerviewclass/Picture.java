package com.example.recyclerviewclass;

import java.util.ArrayList;

public class Picture {

    private ArrayList<String> urlImages;
    private String desc;
    private String text;

    public Picture(ArrayList<String> urlImages, String desc, String text) {
        this.urlImages = urlImages;
        this.desc = desc;
        this.text = text;
    }

    public ArrayList<String> getUrlImages() {
        return urlImages;
    }

    public void setUrlImages(ArrayList<String> urlImages) {
        this.urlImages = urlImages;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
