package com.garagu.swapi.presentation.common;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.garagu.swapi.R;

/**
 * Created by garagu.
 */
public class CardDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, recyclerView, state);
        int space = recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.margin);
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            outRect.top = space;
        }
        outRect.bottom = space;
        outRect.left = space;
        outRect.right = space;
    }

}