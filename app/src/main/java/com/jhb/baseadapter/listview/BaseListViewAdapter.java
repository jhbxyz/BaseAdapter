package com.jhb.baseadapter.listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by jhb on 2018/1/29.
 */

public abstract class BaseListViewAdapter<T> extends BaseAdapter {

    public List<T> dataList;
    public int itemTypeCount = 1;

    public BaseListViewAdapter(List<T> dataList) {
        this.dataList = dataList;
    }

    /**
     * @param dataList      数据
     * @param itemTypeCount 条目类型的个数
     */
    public BaseListViewAdapter(List<T> dataList, int itemTypeCount) {
        if (itemTypeCount < 1) {
            throw new RuntimeException("itemTypeCount must >= 1");
        }
        this.dataList = dataList;
        this.itemTypeCount = itemTypeCount;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public T getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return itemTypeCount;
    }

    /**
     * 多条目必须复写此方法
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return getItemType(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BaseListViewHolder holder = BaseListViewHolder.get(position, getlayoutId(getItemType(position)), convertView, parent);

        convert(holder, dataList.get(position), getItemType(position), position);

        return holder.getConvertView();
    }

    protected abstract int getlayoutId(int itemType);

    protected abstract int getItemType(int position);

    protected abstract void convert(BaseListViewHolder holder, T t, int itemType, int position);

}
