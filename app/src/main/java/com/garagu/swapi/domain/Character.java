package com.garagu.swapi.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by garagu.
 */
public class Character implements Parcelable {

    private int id;
    private String name;
    private String height;
    private String mass;
    private List<String> films;

    private Character(int id, String name, String height, String mass, List<String> films) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.films = films;
    }

    public int getId() {
        return id;
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

    public List<String> getFilms() {
        return films;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.height);
        dest.writeString(this.mass);
        dest.writeStringList(this.films);
    }

    private Character(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.height = in.readString();
        this.mass = in.readString();
        this.films = in.createStringArrayList();
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel source) {
            return new Character(source);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    public static class Builder {

        private int id;
        private String name;
        private String height;
        private String mass;
        private List<String> filmsIds;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withHeight(String height) {
            this.height = height;
            return this;
        }

        public Builder withMass(String mass) {
            this.mass = mass;
            return this;
        }

        public Builder withFilms(List<String> filmsIds) {
            this.filmsIds = filmsIds;
            return this;
        }

        public Character build() {
            return new Character(id, name, height, mass, filmsIds);
        }

    }
}
