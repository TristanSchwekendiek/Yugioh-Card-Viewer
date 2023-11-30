package com.example.comp1011assignment21207799;

import com.google.gson.annotations.SerializedName;


//The class exists because the card image urls are nested
public class CardImage {
    @SerializedName("image_url_small")
    private String imageUrlSmall;

    public String getUrl() {return imageUrlSmall; }

}
