package com.jet.apiwhisky.Models;

import com.google.gson.annotations.SerializedName;

public class Whisky {
    @SerializedName("auction_slug")
    private String whiskyName;

    public String getWhiskyName() {
        return whiskyName;
    }

    public void setWhiskyName(String whiskyName) {
        this.whiskyName = whiskyName;
    }
}
