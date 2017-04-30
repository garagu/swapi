package com.garagu.swapi.data.sources;

import com.garagu.swapi.data.entities.FilmEntity;

import io.reactivex.Observable;

/**
 * Created by garagu.
 */
public interface FilmDataSource {

    Observable<FilmEntity> getFilm(String id);

}