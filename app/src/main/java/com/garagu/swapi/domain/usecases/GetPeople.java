package com.garagu.swapi.domain.usecases;

import com.garagu.swapi.domain.Character;
import com.garagu.swapi.domain.PaginatedList;
import com.garagu.swapi.domain.repositories.PeopleRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by garagu.
 */
public class GetPeople extends UseCase<Integer, PaginatedList<Character>> {

    private PeopleRepository repository;

    @Inject
    GetPeople(PeopleRepository repository) {
        this.repository = repository;
    }

    @Override
    Observable<PaginatedList<Character>> buildObservable(Integer page) {
        return repository.getPeople(page);
    }

}