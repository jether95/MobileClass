package com.jet.finalproyect.Models;

import com.google.gson.annotations.SerializedName;

public class Quotes {

    @SerializedName("quote")
    private String quote;

    @SerializedName("author")
    private String author;

    @SerializedName("series")
    private  String series;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
