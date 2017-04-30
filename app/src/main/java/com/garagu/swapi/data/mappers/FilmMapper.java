package com.garagu.swapi.data.mappers;

import com.garagu.swapi.data.entities.FilmEntity;
import com.garagu.swapi.domain.Film;

/**
 * Created by garagu.
 */
public class FilmMapper implements Mapper<FilmEntity, Film> {

    @Override
    public Film mapEntityToModel(FilmEntity entity) {
        return new Film.Builder()
                .withTitle(entity.getTitle())
                .withReleaseDate(entity.getReleaseDate())
                .build();
    }

}