package com.example.comp1011assignment21207799;

import com.google.gson.annotations.SerializedName;

public class YugiohDataResponse {
    @SerializedName("data")
    private YugiohDetails[] cardDetails;

    public YugiohDetails[] getCardDetails() {
        return cardDetails;
    }
}
