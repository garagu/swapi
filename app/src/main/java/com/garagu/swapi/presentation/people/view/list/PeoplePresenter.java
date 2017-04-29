package com.garagu.swapi.presentation.people.view.list;

import com.garagu.swapi.domain.Character;
import com.garagu.swapi.domain.PaginatedList;
import com.garagu.swapi.domain.usecases.GetPeople;
import com.garagu.swapi.presentation.common.BasePresenter;
import com.garagu.swapi.presentation.common.BaseView;
import com.garagu.swapi.presentation.people.view.list.PeoplePresenter.PeopleView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by garagu.
 */
public class PeoplePresenter extends BasePresenter<PeopleView> {

    private GetPeople getPeople;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    PeoplePresenter(GetPeople getPeople) {
        this.getPeople = getPeople;
    }

    void init(int loadedCharacters) {
        if (loadedCharacters == 0) {
            searchPeople(1);
        }
    }

    void destroy() {
        compositeDisposable.dispose();
    }

    void onCharacterClick(Character character) {
        getView().openDetail(character);
    }

    private void searchPeople(int page) {
        getView().showProgress();
        getPeople.execute(page)
                .doFinally(() -> getView().hideProgress())
                .subscribe(
                        charactersPaginatedList -> getView().addCharactersToList(charactersPaginatedList),
                        error -> getView().showError(error.getMessage()),
                        () -> getView().hideProgress(),
                        disposable -> compositeDisposable.add(disposable)
                );
    }

    interface PeopleView extends BaseView {
        void hideProgress();

        void openDetail(Character character);

        void addCharactersToList(PaginatedList<Character> characterPaginatedList);

        void showError(String message);

        void showProgress();
    }

}