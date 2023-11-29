package com.example.comp1011assignment21207799;

import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
public class YugiohCard {
    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("effect")
    String effect;

    @SerializedName("atk")
    String attack;

    @SerializedName("def")
    String defense;

    @SerializedName("type")
    String type;

    @SerializedName("level")
    String level;

    @SerializedName("race")
    String race;

    @SerializedName("attribute")
    String attribute;

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
        return attack;
    }

    public String getDef() {
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

