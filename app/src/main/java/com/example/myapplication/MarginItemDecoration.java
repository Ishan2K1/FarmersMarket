package com.example.myapplication;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class MarginItemDecoration extends RecyclerView.ItemDecoration {
    private final int horizontalMargin;

    public MarginItemDecoration(int horizontalMargin) {
        this.horizontalMargin = horizontalMargin;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = horizontalMargin;
        outRect.right = horizontalMargin;
    }
}
