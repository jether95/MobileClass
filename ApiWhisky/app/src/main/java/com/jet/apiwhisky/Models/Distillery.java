package com.jet.apiwhisky.Models;

import com.google.gson.annotations.SerializedName;

public class Distillery {
    @SerializedName("name")
    private String distilleryName;

    public String getDistilleryName() {
        return distilleryName;
    }

    public void setDistilleryName(String distilleryName) {
        this.distilleryName = distilleryName;
    }
}
