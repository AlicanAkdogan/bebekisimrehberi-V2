package com.alican.bebeksimrehberi.F2;

public class secondName {

    private int name_id;
    private String name, names_explanation, fav;

    public secondName() {
    }

    public secondName(int name_id, String name, String names_explanation, String fav) {
        this.name_id = name_id;
        this.name = name;
        this.names_explanation = names_explanation;
        this.fav = fav;
    }

    public int getName_id() {
        return name_id;
    }

    public void setName_id(int name_id) {
        this.name_id = name_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNames_explanation() {
        return names_explanation;
    }

    public void setNames_explanation(String names_explanation) {
        this.names_explanation = names_explanation;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }
}
