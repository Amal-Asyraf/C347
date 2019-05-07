package com.example.demoexplicitintent;

import java.io.Serializable;

public class Hero implements Serializable {
    String name;
    int strenght, technicalProwess;

    public Hero(String name, int strenght, int technicalProwess) {
        this.name = name;
        this.strenght = strenght;
        this.technicalProwess = technicalProwess;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getTechnicalProwess() {
        return technicalProwess;
    }

    public void setTechnicalProwess(int technicalProwess) {
        this.technicalProwess = technicalProwess;
    }
}
