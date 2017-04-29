package com.garagu.swapi.domain.repositories;

import com.garagu.swapi.data.entities.PeopleEntity;
import com.garagu.swapi.data.mappers.PeopleMapper;
import com.garagu.swapi.data.sources.PeopleDataSource;
import com.garagu.swapi.domain.Character;
import com.garagu.swapi.domain.PaginatedList;

import io.reactivex.Observable;

/**
 * Created by garagu.
 */
public class PeopleRepository {

    private PeopleDataSource peopleDataSource;

    public PeopleRepository(PeopleDataSource peopleDataSource) {
        this.peopleDataSource = peopleDataSource;
    }

    public Observable<PaginatedList<Character>> getPeople(int page) {
        return peopleDataSource.getPeople(page).map(this::mapEntityToModel);
    }

    private PaginatedList<Character> mapEntityToModel(PeopleEntity entity) {
        PeopleMapper mapper = new PeopleMapper();
        return mapper.mapEntityToModel(entity);
    }

}