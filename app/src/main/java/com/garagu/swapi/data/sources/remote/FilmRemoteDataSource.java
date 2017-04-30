package com.garagu.swapi.data.sources.remote;

import com.garagu.swapi.data.entities.FilmEntity;
import com.garagu.swapi.data.net.ApiConnection;
import com.garagu.swapi.data.net.StarWarsAPI;
import com.garagu.swapi.data.sources.FilmDataSource;

import io.reactivex.Observable;

/**
 * Created by garagu.
 */
public class FilmRemoteDataSource implements FilmDataSource {

    @Override
    public Observable<FilmEntity> getFilm(String id) {
        return ApiConnection.getServices(StarWarsAPI.class, StarWarsAPI.BASE_URL).getFilm(id);
    }

}