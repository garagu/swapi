package com.garagu.swapi.domain;

/**
 * Created by garagu.
 */
public class Film {

    private String title;
    private String releaseDate;

    private Film(String title, String releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public static class Builder {

        private String title;
        private String releaseDate;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Film build() {
            return new Film(title, releaseDate);
        }

    }

}