package com.jet.apiwhisky.Models;

import com.google.gson.annotations.SerializedName;

public class Whisky {
    @SerializedName("auction_slug")
    private String whiskyName;

    @SerializedName("slug")
    private String whiskySlug;

    @SerializedName("buyers_fee")
    private String whiskyBuyers;

    @SerializedName("sellers_fee")
    private String whiskySellers;

    @SerializedName("reserve_fee")
    private String whiskyReserve;

    @SerializedName("listing_fee")
    private String whiskyListing;

    @SerializedName("url")
    private String WhiskyUrl;

    public String getWhiskyUrl() {
        return WhiskyUrl;
    }

    public void setWhiskyUrl(String whiskyUrl) {
        WhiskyUrl = whiskyUrl;
    }

    public String getWhiskyBuyers() {
        return whiskyBuyers;
    }

    public void setWhiskyBuyers(String whiskyBuyers) {
        this.whiskyBuyers = whiskyBuyers;
    }

    public String getWhiskySellers() {
        return whiskySellers;
    }

    public void setWhiskySellers(String whiskySellers) {
        this.whiskySellers = whiskySellers;
    }

    public String getWhiskyReserve() {
        return whiskyReserve;
    }

    public void setWhiskyReserve(String whiskyReserve) {
        this.whiskyReserve = whiskyReserve;
    }

    public String getWhiskyListing() {
        return whiskyListing;
    }

    public void setWhiskyListing(String whiskyListing) {
        this.whiskyListing = whiskyListing;
    }

    public String getWhiskySlug() {
        return whiskySlug;
    }

    public void setWhiskySlug(String whiskySlug) {
        this.whiskySlug = whiskySlug;
    }

    public String getWhiskyName() {
        return whiskyName;
    }

    public void setWhiskyName(String whiskyName) {
        this.whiskyName = whiskyName;
    }
}
