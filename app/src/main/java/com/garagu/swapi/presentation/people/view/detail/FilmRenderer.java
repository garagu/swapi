package com.garagu.swapi.presentation.people.view.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garagu.swapi.R;
import com.garagu.swapi.domain.Film;
import com.pedrogomez.renderers.Renderer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by garagu.
 */
public class FilmRenderer extends Renderer<Film> {

    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_release_date)
    TextView txtReleaseDate;

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_film, parent, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void hookListeners(View rootView) {
        // Empty implementation substituted with the usage of ButterKnife
    }

    @Override
    public void render() {
        Film film = getContent();
        txtTitle.setText(film.getTitle());
        txtReleaseDate.setText(film.getReleaseDate());
    }

    @Override
    protected void setUpView(View rootView) {
        // Empty implementation substituted with the usage of ButterKnife
    }

}