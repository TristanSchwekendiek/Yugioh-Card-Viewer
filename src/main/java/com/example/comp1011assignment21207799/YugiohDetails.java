package com.example.comp1011assignment21207799;

import com.google.gson.annotations.SerializedName;

public class YugiohDetails {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("effect")
    private String effect;

    @SerializedName("atk")
    private String attack;

    @SerializedName("def")
    private String defense;

    @SerializedName("type")
    private String type;

    @SerializedName("level")
    private String level;

    @SerializedName("race")
    private String race;

    @SerializedName("attribute")
    private String attribute;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }

    public String getAttack() {
        return attack;
    }

    public String getDefense() {
        return defense;
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
}


