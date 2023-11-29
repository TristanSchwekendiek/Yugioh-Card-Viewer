package com.example.comp1011assignment21207799;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIResponse {

    @SerializedName("Search")
    public ArrayList<YugiohCard> cards;

    private String totalResults;

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
}
