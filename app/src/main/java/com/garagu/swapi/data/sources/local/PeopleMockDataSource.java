package com.garagu.swapi.data.sources.local;

import com.garagu.swapi.data.entities.CharacterEntity;
import com.garagu.swapi.data.entities.PeopleEntity;
import com.garagu.swapi.data.sources.PeopleDataSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by garagu.
 */
public class PeopleMockDataSource implements PeopleDataSource {

    @Override
    public Observable<PeopleEntity> getPeople(int page) {
        List<CharacterEntity> people = new ArrayList<>();
        people.add(new CharacterEntity("http://swapi.co/api/people/1/", "Luke Skywalker", "172", "77", new String[]{"http://swapi.co/api/films/1/", "http://swapi.co/api/films/2/"}));
        people.add(new CharacterEntity("http://swapi.co/api/people/3/", "R2-D2", "96", "32", new String[]{"http://swapi.co/api/films/1/"}));
        return Observable.just(new PeopleEntity(2, null, null, people));
    }

}