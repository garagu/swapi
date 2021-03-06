package com.garagu.swapi.presentation.common;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.garagu.swapi.presentation.di.AppComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by garagu.
 */
public abstract class BaseFragment extends Fragment {

    private View rootView;
    private Unbinder unbinder;

    protected abstract int getLayoutId();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), container, false);
        onPrepareFragment();
        return rootView;
    }

    @CallSuper
    protected void onPrepareFragment() {
        unbinder = ButterKnife.bind(this, rootView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    protected AppComponent getAppComponent() {
        return ((BaseActivity) getActivity()).getAppComponent();
    }

    protected void showSnackbar(String message) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show();
    }

}