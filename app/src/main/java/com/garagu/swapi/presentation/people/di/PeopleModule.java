package com.garagu.swapi.presentation.people.di;

import com.garagu.swapi.data.sources.FilmDataSource;
import com.garagu.swapi.data.sources.PeopleDataSource;
import com.garagu.swapi.data.sources.remote.FilmRemoteDataSource;
import com.garagu.swapi.data.sources.remote.PeopleRemoteDataSource;
import com.garagu.swapi.domain.repositories.FilmRepository;
import com.garagu.swapi.domain.repositories.PeopleRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by garagu.
 */
@Module
public class PeopleModule {

    @Provides
    PeopleRepository providePeopleRepository() {
        PeopleDataSource peopleDataSource = new PeopleRemoteDataSource();
        // PeopleDataSource peopleDataSource = new PeopleMockDataSource();
        return new PeopleRepository(peopleDataSource);
    }

    @Provides
    FilmRepository provideFilmRepository() {
        FilmDataSource filmDataSource = new FilmRemoteDataSource();
        // FilmDataSource filmDataSource = new FilmMockDataSource();
        return new FilmRepository(filmDataSource);
    }

}