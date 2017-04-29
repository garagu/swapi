package com.garagu.swapi.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by garagu.
 */
public class CharacterEntity {

    private String url;
    private String name;
    private String height;
    private String mass;
    @SerializedName("films")
    private String[] filmsUrls;

    public CharacterEntity(String url, String name, String height, String mass, String[] filmsUrls) {
        this.url = url;
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.filmsUrls = filmsUrls;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String[] getFilmsUrls() {
        return filmsUrls;
    }

}