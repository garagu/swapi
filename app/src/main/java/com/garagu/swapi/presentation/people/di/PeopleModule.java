package com.garagu.swapi.presentation.people.di;

import com.garagu.swapi.data.sources.PeopleDataSource;
import com.garagu.swapi.data.sources.remote.PeopleRemoteDataSource;
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
        //PeopleDataSource peopleDataSource = new PeopleMockDataSource();
        PeopleDataSource peopleDataSource = new PeopleRemoteDataSource();
        return new PeopleRepository(peopleDataSource);
    }

}