package com.jet.finalproyect.Models;

import com.google.gson.annotations.SerializedName;

public class Deaths {

    @SerializedName("death")
    private String death;

    @SerializedName("cause")
    private String cause;

    @SerializedName("responsible")
    private String responsible;

    @SerializedName("last_words")
    private String last_words;

    @SerializedName("season")
    private String season;

    @SerializedName("episode")
    private String episode;

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getLast_words() {
        return last_words;
    }

    public void setLast_words(String last_words) {
        this.last_words = last_words;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }
}
