package com.example.recyclerviewclass;

public class Picture {

    private String urlImage;
    private String desc;
    private String text;

    public Picture(String urlImage, String desc, String text) {
        this.urlImage = urlImage;
        this.desc = desc;
        this.text = text;
    }


    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
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
