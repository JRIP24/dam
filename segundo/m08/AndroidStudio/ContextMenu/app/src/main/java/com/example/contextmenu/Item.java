package com.example.contextmenu;

public class Item {
    private String itemName;
    private int imageName;
    private String itemDesc;
    public Item(String itemName, int imageName, String itemDesc) {
        this.itemName = itemName;
        this.imageName = imageName;
        this.itemDesc = itemDesc;
    }
    public String getItemDesc() {
        return itemDesc;
    }
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getImageName() {
        return imageName;
    }
    public void setImageName(int imageName) {
        this.imageName = imageName;
    }
}
