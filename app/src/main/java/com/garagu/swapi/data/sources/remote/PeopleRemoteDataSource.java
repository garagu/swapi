package com.garagu.swapi.data.sources.remote;

import com.garagu.swapi.data.entities.PeopleEntity;
import com.garagu.swapi.data.net.ApiConnection;
import com.garagu.swapi.data.net.StarWarsAPI;
import com.garagu.swapi.data.sources.PeopleDataSource;

import io.reactivex.Observable;

/**
 * Created by garagu.
 */
public class PeopleRemoteDataSource implements PeopleDataSource {

    @Override
    public Observable<PeopleEntity> getPeople(int page) {
        return ApiConnection.getServices(StarWarsAPI.class, StarWarsAPI.BASE_URL).getPeople(page);
    }

}