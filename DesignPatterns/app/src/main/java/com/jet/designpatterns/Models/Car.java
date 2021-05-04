package com.jet.designpatterns.Models;

import android.graphics.drawable.Drawable;

public class Car {
    private String name;
    private String cylinderCapacity;
    private String model;
    private String value;
    private Drawable image;

    public Car() {

    }

    public Car(String name, String cylinderCapacity, String model, String value, Drawable image) {
        this.name = name;
        this.cylinderCapacity = cylinderCapacity;
        this.model = model;
        this.value = value;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(String cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
