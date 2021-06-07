package com.jet.apiwhisky.Models;

import com.google.gson.annotations.SerializedName;

public class Whisky {
    @SerializedName("name")
    private String whiskyName;

    public Whisky(String whiskyName) {
        this.whiskyName = whiskyName;
    }

    public String getWhiskyName() {
        return whiskyName;
    }

    public void setWhiskyName(String whiskyName) {
        this.whiskyName = whiskyName;
    }
}
