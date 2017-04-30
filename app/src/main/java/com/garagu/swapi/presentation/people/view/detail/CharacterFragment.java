package com.garagu.swapi.presentation.people.view.detail;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.garagu.swapi.R;
import com.garagu.swapi.domain.Character;
import com.garagu.swapi.domain.Film;
import com.garagu.swapi.presentation.common.BaseFragment;
import com.garagu.swapi.presentation.common.CardDecoration;
import com.garagu.swapi.presentation.people.di.DaggerPeopleComponent;
import com.garagu.swapi.presentation.people.di.PeopleModule;
import com.garagu.swapi.presentation.people.view.detail.CharacterPresenter.CharacterView;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by garagu.
 */
public class CharacterFragment extends BaseFragment implements CharacterView {

    private static final String KEY_CHARACTER = "character";

    @Inject
    CharacterPresenter presenter;

    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_height_mass)
    TextView txtHeightMass;
    @BindView(R.id.rv_films)
    RecyclerView rvFilms;

    private Character character;
    private RVRendererAdapter<Film> adapter;

    public static CharacterFragment newInstance(Character character) {
        Bundle args = new Bundle();
        args.putParcelable(KEY_CHARACTER, character);
        CharacterFragment fragment = new CharacterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_character;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        character = getArguments().getParcelable(KEY_CHARACTER);
    }

    @Override
    protected void onPrepareFragment() {
        super.onPrepareFragment();
        initDependencyInjector();
        initComponents();
        initPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.destroy();
    }

    private void initDependencyInjector() {
        DaggerPeopleComponent.builder()
                .appComponent(getAppComponent())
                .peopleModule(new PeopleModule())
                .build()
                .inject(this);
    }

    private void initComponents() {
        txtName.setText(character.getName());
        txtHeightMass.setText(getString(R.string.character_height_mass, character.getHeight(), character.getMass()));
        initFilmList();
    }

    private void initFilmList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvFilms.setLayoutManager(layoutManager);
        rvFilms.addItemDecoration(new CardDecoration());
        FilmRenderer renderer = new FilmRenderer();
        adapter = new RVRendererAdapter<>(new RendererBuilder<>(renderer), new ListAdapteeCollection<>());
        rvFilms.setAdapter(adapter);
    }

    private void initPresenter() {
        presenter.setView(this);
        presenter.init(character.getFilms());
    }

    @Override
    public void hideProgress() {
        // TODO
    }

    @Override
    public void showError(String message) {
        showSnackbar(message);
    }

    @Override
    public void addFilmToList(Film film) {
        int newPosition = adapter.getItemCount();
        adapter.add(film);
        adapter.notifyItemInserted(newPosition);
    }

    @Override
    public void showProgress() {
        // TODO
    }

}