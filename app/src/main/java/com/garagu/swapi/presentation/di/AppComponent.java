package com.garagu.swapi.presentation.di;

import android.content.Context;

import com.garagu.swapi.presentation.common.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by garagu.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(BaseActivity baseActivity);

    Context context();

}