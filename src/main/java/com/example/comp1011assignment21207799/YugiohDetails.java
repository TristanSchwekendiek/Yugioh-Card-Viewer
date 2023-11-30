package com.example.comp1011assignment21207799;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class YugiohDetails {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("desc")
    private String effect;

    @SerializedName("atk")
    private String atk;

    @SerializedName("def")
    private String def;

    @SerializedName("type")
    private String type;

    @SerializedName("level")
    private String level;

    @SerializedName("race")
    private String race;

    @SerializedName("attribute")
    private String attribute;
    @SerializedName("card_images")
    private List<CardImage> cardImages;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }

    public String getAtk() {
        return atk;
    }

    public String getDef() {
        return def;
    }

    public String getType() {
        return type;
    }

    public String getLevel() {
        return level;
    }

    public String getRace() {
        return race;
    }

    public String getAttribute() {
        return attribute;
    }

    public List<CardImage> getCardImages() {return cardImages; }

}


