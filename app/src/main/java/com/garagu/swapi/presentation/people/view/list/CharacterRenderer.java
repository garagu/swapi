package com.garagu.swapi.presentation.people.view.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garagu.swapi.R;
import com.garagu.swapi.domain.Character;
import com.pedrogomez.renderers.Renderer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by garagu.
 */
class CharacterRenderer extends Renderer<Character> {

    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_height_mass)
    TextView txtHeightMass;

    private OnCharacterClickListener onCharacterClickListener;

    CharacterRenderer(OnCharacterClickListener onCharacterClickListener) {
        this.onCharacterClickListener = onCharacterClickListener;
    }

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_character, parent, false);
        ButterKnife.bind(this, view);
        view.setOnClickListener(v -> onCharacterClickListener.onClick(getContent()));
        return view;
    }

    @Override
    protected void hookListeners(View rootView) {
        // Empty implementation substituted with the usage of ButterKnife
    }

    @Override
    public void render() {
        Character character = getContent();
        txtName.setText(character.getName());
        txtHeightMass.setText(getContext().getString(R.string.character_height_mass, character.getHeight(), character.getMass()));
    }

    @Override
    protected void setUpView(View rootView) {
        // Empty implementation substituted with the usage of ButterKnife
    }

    interface OnCharacterClickListener {
        void onClick(Character character);
    }

}