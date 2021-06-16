package com.jet.finalproyect.Models;

import com.google.gson.annotations.SerializedName;

public class Episodes {

    @SerializedName("episode")
    private String episode;

    @SerializedName("title")
    private String title;

    @SerializedName("season")
    private String season;

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
