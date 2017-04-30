package com.garagu.swapi.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by garagu.
 */

public class FilmEntity {

    private String title;
    @SerializedName("release_date")
    private String releaseDate;

    public FilmEntity(String title, String releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

}