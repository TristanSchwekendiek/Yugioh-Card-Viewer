package com.example.comp1011assignment21207799;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class APIResponse {

    @SerializedName("Search")
    private ArrayList<YugiohCard> cards;
    private String totalResults;
    @SerializedName("data")
    private YugiohCard data;


    @SerializedName("Response")
    private String response;

    public ArrayList<YugiohCard> getCards() {
        return cards;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }

    public YugiohCard getData() {
        return data;
    }

}
