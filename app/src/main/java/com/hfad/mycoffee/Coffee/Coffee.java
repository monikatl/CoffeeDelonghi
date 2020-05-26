package com.hfad.mycoffee.Coffee;


import java.util.ArrayList;
import java.util.List;

public abstract class Coffee {

    private String name;
    private String description;
    private int imageResourceId;
    private boolean isDouble;
    private boolean isSugar;

    public Coffee(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public Coffee(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setDouble(boolean Double) {
        isDouble = Double;
    }

    public void setSugar(boolean sugar) {
        isSugar = sugar;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean isDouble() {
        return isDouble;
    }

    public boolean isSugar() {
        return isSugar;
    }


    public Coffee (){
    }


    @Override
    public String toString() {
        return name;
    }


}
