package com.garagu.swapi.presentation.people.view.list;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.garagu.swapi.R;
import com.garagu.swapi.domain.Character;
import com.garagu.swapi.domain.PaginatedList;
import com.garagu.swapi.presentation.common.BaseFragment;
import com.garagu.swapi.presentation.common.CardDecoration;
import com.garagu.swapi.presentation.people.di.DaggerPeopleComponent;
import com.garagu.swapi.presentation.people.di.PeopleModule;
import com.garagu.swapi.presentation.people.view.detail.CharacterFragment;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by garagu.
 */
public class PeopleFragment extends BaseFragment implements PeoplePresenter.PeopleView {

    @Inject
    PeoplePresenter presenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private RVRendererAdapter<Character> adapter;

    public static PeopleFragment newInstance() {
        return new PeopleFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new CardDecoration());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // TODO check list scroll and pagination
            }
        });
        if (adapter == null) {
            CharacterRenderer renderer = new CharacterRenderer(character -> presenter.onCharacterClick(character));
            adapter = new RVRendererAdapter<>(new RendererBuilder<>(renderer), new ListAdapteeCollection<>());
        }
        recyclerView.setAdapter(adapter);
    }

    private void initPresenter() {
        presenter.setView(this);
        presenter.init(adapter.getItemCount());
    }

    @Override
    public void hideProgress() {
        // TODO
    }

    @Override
    public void openDetail(Character character) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_container, CharacterFragment.newInstance(character))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void addCharactersToList(PaginatedList<Character> characterPaginatedList) {
        adapter.addAll(characterPaginatedList.getItems());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {
        showSnackbar(message);
    }

    @Override
    public void showProgress() {
        // TODO
    }

}