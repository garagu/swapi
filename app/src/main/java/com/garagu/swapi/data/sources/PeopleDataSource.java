package com.garagu.swapi.data.sources;

import com.garagu.swapi.data.entities.PeopleEntity;

import io.reactivex.Observable;

/**
 * Created by garagu.
 */
public interface PeopleDataSource {

    Observable<PeopleEntity> getPeople(int page);

}
