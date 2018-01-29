package com.jhb.baseadapter.listview;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jhb on 2018/1/29.
 */

public class BaseListViewHolder {
    private int mLayoutId;
    protected View mConvertView;
    private SparseArray<View> views;

    public BaseListViewHolder(int layoutId, View mConvertView) {
        views = new SparseArray<>();
        this.mLayoutId = layoutId;
        this.mConvertView = mConvertView;
    }

    public static BaseListViewHolder get(int position, int layoutId, View convertView, ViewGroup parent) {
        BaseListViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);

            holder = new BaseListViewHolder(layoutId, convertView);
            convertView.setTag(holder);
        } else {
            holder = (BaseListViewHolder) convertView.getTag();
        }

        return holder;
    }


    public <T extends View> T getView(int viewId) {
        T t = (T) views.get(viewId);
        if (t == null) {
            t = mConvertView.findViewById(viewId);
            views.put(viewId, t);
        }
        return t;
    }

    public BaseListViewHolder setText(int viewId, CharSequence c) {
        TextView textView = getView(viewId);
        if (textView != null) {
            textView.setText(c);
        }
        return this;
    }


    public View getConvertView(){
        return mConvertView;
    }
}
