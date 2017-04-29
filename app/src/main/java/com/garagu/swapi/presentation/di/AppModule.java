package com.garagu.swapi.presentation.di;

import android.content.Context;

import com.garagu.swapi.presentation.SwapiApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by garagu.
 */
@Module
public class AppModule {

    private final SwapiApplication application;

    public AppModule(SwapiApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application.getApplicationContext();
    }

}
