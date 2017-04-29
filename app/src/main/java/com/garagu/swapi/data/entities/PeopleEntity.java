package com.garagu.swapi.data.entities;

import java.util.List;

/**
 * Created by garagu.
 */
public class PeopleEntity {

    private int count;
    private String next;
    private String previous;
    private List<CharacterEntity> results;

    public PeopleEntity(int count, String next, String previous, List<CharacterEntity> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<CharacterEntity> getResults() {
        return results;
    }

}