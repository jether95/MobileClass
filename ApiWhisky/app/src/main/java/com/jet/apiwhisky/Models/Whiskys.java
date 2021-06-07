package com.jet.apiwhisky.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Whiskys {
    @SerializedName("auctions_info")
    List<Whisky> whiskyList;

    public List<Whisky> getWhiskyList() {
        return whiskyList;
    }

    public void setWhiskyList(List<Whisky> whiskyList){
        this.whiskyList = whiskyList;
    }
}
