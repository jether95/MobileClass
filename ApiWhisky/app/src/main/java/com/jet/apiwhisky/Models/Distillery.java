package com.jet.apiwhisky.Models;

import com.google.gson.annotations.SerializedName;

public class Distillery {
    @SerializedName("distilleries_info")
    private String distilleryName;

    public String getDistilleryName() {
        return distilleryName;
    }

    public void setDistilleryName(String distilleryName) {
        this.distilleryName = distilleryName;
    }
}
