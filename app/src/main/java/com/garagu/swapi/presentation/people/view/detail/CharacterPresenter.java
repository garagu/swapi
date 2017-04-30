package com.garagu.swapi.presentation.people.view.detail;

import com.garagu.swapi.domain.Film;
import com.garagu.swapi.domain.usecases.GetFilm;
import com.garagu.swapi.presentation.common.BasePresenter;
import com.garagu.swapi.presentation.common.BaseView;
import com.garagu.swapi.presentation.people.view.detail.CharacterPresenter.CharacterView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by garagu.
 */
class CharacterPresenter extends BasePresenter<CharacterView> {

    private GetFilm getFilm;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    CharacterPresenter(GetFilm getFilm) {
        this.getFilm = getFilm;
    }

    void init(List<String> filmsIds) {
        getView().showProgress();
        Observable.fromIterable(filmsIds)
                .flatMap(filmId -> getFilm.execute(filmId))
                .subscribe(
                        film -> getView().addFilmToList(film),
                        error -> getView().showError(error.getMessage()),
                        () -> getView().hideProgress(),
                        disposable -> compositeDisposable.add(disposable)
                );
    }

    void destroy() {
        compositeDisposable.dispose();
    }

    interface CharacterView extends BaseView {
        void hideProgress();

        void showError(String message);

        void addFilmToList(Film film);

        void showProgress();
    }

}