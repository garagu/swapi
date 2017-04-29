package com.garagu.swapi.presentation.people.di;

import com.garagu.swapi.presentation.di.ActivityScope;
import com.garagu.swapi.presentation.di.AppComponent;
import com.garagu.swapi.presentation.people.view.list.PeopleFragment;

import dagger.Component;

/**
 * Created by garagu.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {PeopleModule.class})
public interface PeopleComponent extends AppComponent {

    void inject(PeopleFragment fragment);

}