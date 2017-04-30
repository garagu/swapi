package com.garagu.swapi.domain.usecases;

import com.garagu.swapi.domain.Film;
import com.garagu.swapi.domain.repositories.FilmRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by garagu.
 */
public class GetFilm extends UseCase<String, Film> {

    private FilmRepository repository;

    @Inject
    GetFilm(FilmRepository repository) {
        this.repository = repository;
    }

    @Override
    Observable<Film> buildObservable(String id) {
        return repository.getFilm(id);
    }

}