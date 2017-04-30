package com.garagu.swapi.data.sources.local;

import com.garagu.swapi.data.entities.FilmEntity;
import com.garagu.swapi.data.sources.FilmDataSource;

import io.reactivex.Observable;

/**
 * Created by garagu.
 */

public class FilmMockDataSource implements FilmDataSource {

    @Override
    public Observable<FilmEntity> getFilm(String id) {
        return Observable.just(new FilmEntity(id.equals("1") ? "A New Hope" : "Empire Strikes Back", "00/00/0000"));
    }

}