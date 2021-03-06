package com.garagu.swapi.presentation.common;

/**
 * Created by garagu.
 */
public abstract class BasePresenter<T extends BaseView> {

    private T view;

    protected final T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }

}