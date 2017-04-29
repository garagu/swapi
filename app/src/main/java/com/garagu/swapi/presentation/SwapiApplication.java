package com.garagu.swapi.presentation;

import android.app.Application;

import com.garagu.swapi.presentation.di.AppComponent;
import com.garagu.swapi.presentation.di.AppModule;
import com.garagu.swapi.presentation.di.DaggerAppComponent;

/**
 * Created by garagu.
 */

public class SwapiApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDependencyInjector();
    }

    private void initDependencyInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}