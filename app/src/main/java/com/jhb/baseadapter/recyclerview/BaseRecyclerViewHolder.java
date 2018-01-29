package com.jhb.baseadapter.recyclerview;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jhb on 2018/1/29.
 */

public class BaseRecyclerViewHolder extends ViewHolder {
    private SparseArray<View> views;

    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<>();
    }

    public BaseRecyclerViewHolder setText(int viewId, CharSequence c) {
        TextView textView = getView(viewId);
        if (textView != null) {
            textView.setText(c);
        }
        return this;
    }

    public <T extends View> T getView(int viewId) {
        T t = (T) views.get(viewId);
        if (t == null) {
            t = itemView.findViewById(viewId);
            views.put(viewId, t);
        }
        return t;
    }

}
