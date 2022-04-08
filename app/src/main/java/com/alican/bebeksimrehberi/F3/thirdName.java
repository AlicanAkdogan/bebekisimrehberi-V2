package com.alican.bebeksimrehberi.F3;

public class thirdName {

    private int id, image;
    private String text;

    public thirdName() {
    }

    public thirdName(int id, int image, String text) {
        this.id = id;
        this.image = image;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
