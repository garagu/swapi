package com.garagu.swapi.domain.repositories;

import com.garagu.swapi.data.entities.FilmEntity;
import com.garagu.swapi.data.mappers.FilmMapper;
import com.garagu.swapi.data.sources.FilmDataSource;
import com.garagu.swapi.domain.Film;

import io.reactivex.Observable;

/**
 * Created by garagu.
 */
public class FilmRepository {

    private FilmDataSource filmDataSource;

    public FilmRepository(FilmDataSource filmDataSource) {
        this.filmDataSource = filmDataSource;
    }

    public Observable<Film> getFilm(String id) {
        return filmDataSource.getFilm(id).map(this::mapEntityToModel);
    }

    private Film mapEntityToModel(FilmEntity entity) {
        FilmMapper mapper = new FilmMapper();
        return mapper.mapEntityToModel(entity);
    }

}