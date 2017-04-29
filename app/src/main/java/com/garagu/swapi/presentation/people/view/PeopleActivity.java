package com.garagu.swapi.presentation.people.view;

import android.app.Fragment;

import com.garagu.swapi.presentation.common.BaseActivity;
import com.garagu.swapi.presentation.people.view.list.PeopleFragment;

/**
 * Created by garagu.
 */
public class PeopleActivity extends BaseActivity {

    @Override
    protected Fragment getFragment() {
        return PeopleFragment.newInstance();
    }

}