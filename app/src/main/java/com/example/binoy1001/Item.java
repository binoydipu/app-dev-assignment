package com.example.binoy1001;

public class Item {
    String title;
    String subTitle;
    int image;
    String description;

    public Item(String title, String description, int image, String subTitle) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
